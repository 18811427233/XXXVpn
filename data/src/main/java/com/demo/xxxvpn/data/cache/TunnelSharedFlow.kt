package com.demo.xxxvpn.data.cache

import com.wireguard.android.backend.Tunnel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TunnelSharedFlow @Inject constructor() : SharedFlowTemplate<Tunnel.State> {
    override val flowable = MutableSharedFlow<Tunnel.State>(replay = 1)
}
