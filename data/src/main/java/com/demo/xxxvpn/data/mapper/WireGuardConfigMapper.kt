package com.demo.xxxvpn.data.mapper

import com.wireguard.config.Config
import com.wireguard.config.InetAddresses
import com.wireguard.config.InetEndpoint
import com.wireguard.config.InetNetwork
import com.wireguard.config.Interface
import com.wireguard.config.Peer
import com.demo.xxxvpn.domain.qualifiers.IoDispatcher
import com.demo.xxxvpn.domain.repository.CacheRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.regex.Pattern
import javax.inject.Inject

/**
 * Mapper to generate a new WireGuard Config with a default region
 * This mapper needs an original credential, and it will replace the
 * region inside that credential
 */
class WireGuardConfigMapper @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val cacheRepository: CacheRepository,
) {
    private val LIST_SEPARATOR: Pattern = Pattern.compile("\\s*,\\s*")

    suspend operator fun invoke(region: String, port: Int? = null): Config =
        withContext(ioDispatcher) {
            val credential = cacheRepository.monitorCredential().first()
//            val encryptedConfig = wireGuardEncryptedConfigMapper(name)
//            val origin = encryptedConfig.`interface`
//            val destination = encryptedConfig.peers.first()
            credential!!.let { credential ->
                Timber.d(credential.privateKey+"Connected 00000-----"+credential.peerPublicKey)
            }

            val allowIps = "0.0.0.0/0, ::/0"
            credential!!.let { credential ->
                val peerBuilder = Peer.Builder()
                for (s in LIST_SEPARATOR.split(allowIps)) {
                    peerBuilder.addAllowedIp(InetNetwork.parse(s))
                }

                val interfaceBuilder = Interface.Builder()
                Config.Builder()
                    .setInterface(
                        interfaceBuilder
                            .addDnsServers(
                                LIST_SEPARATOR.split(credential.dns).map {
                                    InetAddresses.parse(it)
                                }
                            )
                            .addAddresses(LIST_SEPARATOR.split(credential.ipV4).map {
                                InetNetwork.parse(it)
                            })
                            .parsePrivateKey(credential.privateKey)
                            .build()
                    )
                    .addPeer(
                        Peer.Builder()
                            .addAllowedIps(
                                LIST_SEPARATOR.split(allowIps).map {
                                    InetNetwork.parse(it)
                                }
                            )
                            .setEndpoint(
                                InetEndpoint.parse("$region:$port")
                            )
                            .parsePublicKey(credential.peerPublicKey)
//                            .parsePreSharedKey(credential.preSharedKey)
                            // Persistent keep-alive is needed to retain handshake state when
                            // there's no data transmitted, otherwise it can produce some weird connection
                            // bugs
                            .setPersistentKeepalive(25)
                            .build()
                    )
                    .build()
            }
        }

    /**
     * Remove region name prefix and replace with the region above
     * The LU is removed and replaced with the region passed (FR) and it will return a new [InetEndpoint]
     */
    private fun getNewPeerEndpoint(
        originalEndpoint: InetEndpoint,
        region: String,
        port: Int?
    ): InetEndpoint {
        if (region.isBlank()) {
            return originalEndpoint
        }

        val selectedPort = port ?: originalEndpoint.port
        val newPeerEndpoint = StringBuilder().apply {
            append(region)
            append(".")
            append(
                originalEndpoint.host
                    .split(".")
                    .drop(1)
                    .joinToString(".")
            )
            append(":")
            append(selectedPort)
        }.toString()

        return InetEndpoint.parse(newPeerEndpoint)
    }
}