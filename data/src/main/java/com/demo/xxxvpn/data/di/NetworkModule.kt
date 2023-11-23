package com.demo.xxxvpn.data.di

import com.ihsanbal.logging.LoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.demo.xxxvpn.data.network.CommonHeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform.Companion.WARN
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val CONNECT_TIMEOUT_SECONDS = 10

//private const val BASE_URL = "https://api.mastervpnapp.com/"
private const val BASE_URL = "http://vpn.mirror-box.xyz/"
//private const val BASE_URL = "http://192.168.10.166:8077/"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .addInterceptor(CommonHeaderInterceptor())
            .addInterceptor(
                LoggingInterceptor
                    .Builder()
                    .log(WARN)
                    .build()
            )
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }
}
