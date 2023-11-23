package com.demo.xxxvpn.domain.entity

data class DeviceIdRequest(val deviceId: String?)

data class ADConfigRequest(val deviceId: String?, val appVersion: String?)

data class LoginRequest(val uuidFlag: String?, val number: String?, val times: String?, val prefix: String?, val versionName: String?, val versionNumber: String?)

data class AccessRequest(val adPointAccessType: Int?, val adPointActionType: Int?, val adPointType: Int?, val dotFlag: String?, val num: Long?, val params: String?)