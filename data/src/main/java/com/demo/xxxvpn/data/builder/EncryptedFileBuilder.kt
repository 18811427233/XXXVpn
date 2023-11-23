package com.demo.xxxvpn.data.builder

import android.content.Context
import androidx.security.crypto.EncryptedFile
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.qualifiers.ApplicationContext
import com.demo.xxxvpn.domain.qualifiers.EncryptionKey
import java.io.File

/**
 * Factory class to encrypt any file with the Android EncryptedFile API
 *
 * @see EncryptedFile
 * @param file the file to encrypt
 */
class EncryptedFileBuilder @AssistedInject constructor(
    @ApplicationContext private val applicationContext: Context,
    @EncryptionKey private val encryptionKey: String,
    private val encryptionScheme: EncryptedFile.FileEncryptionScheme,
    @Assisted private val file: File
) {
    @AssistedFactory
    interface EncryptedFileBuilderFactory {
        fun create(file: File): EncryptedFileBuilder
    }

    fun build(): EncryptedFile =
        EncryptedFile.Builder(
            file,
            applicationContext,
            encryptionKey,
            encryptionScheme
        ).build()
}