package com.demo.xxxvpn.data.mapper

import android.content.Context
import androidx.security.crypto.EncryptedFile
import com.wireguard.config.Config
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.withContext
import com.demo.xxxvpn.data.builder.EncryptedFileBuilder
import com.demo.xxxvpn.domain.qualifiers.IoDispatcher
import timber.log.Timber
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import javax.inject.Inject

/**
 * Mapper to read an encrypted WireGuard config file
 * This uses the Android EncryptedFile API
 */
class WireGuardEncryptedConfigMapper @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val encryptedFileBuilderFactory: EncryptedFileBuilder.EncryptedFileBuilderFactory
) {
    suspend operator fun invoke(name: String): Config = withContext(ioDispatcher) {
        val encryptedFile = buildEncryptedFile(name)
        encryptedFile.openFileInput().use { fileInputStream ->
            ensureActive()
            ByteArrayOutputStream().use { byteArrayOutputStream ->
                var nextByte: Int = fileInputStream.read()
                while (nextByte != -1) {
                    ensureActive()
                    byteArrayOutputStream.write(nextByte)
                    nextByte = fileInputStream.read()
                }
                Timber.d("Decrypted Tunnel Config: \n$byteArrayOutputStream")

                ByteArrayInputStream(byteArrayOutputStream.toByteArray()).use { byteArrayInputStream ->
                    ensureActive()
                    Config.parse(byteArrayInputStream)
                }
            }
        }
    }

    private fun buildEncryptedFile(name: String): EncryptedFile =
        encryptedFileBuilderFactory
            .create(File(applicationContext.filesDir, "$name.conf"))
            .build()
}