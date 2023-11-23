# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclassmembers
-verbose
-dontpreverify

##########
# Enums #
#########
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

##############
# Parcelable #
##############
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class * implements android.os.Parcelable {
    static ** CREATOR;
}
-keepclassmembers class **.R$* {
    public static <fields>;
}

#################
# Serializable #
################
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#########################
# Google Play Services #
########################
-keep class com.google.android.gms.* {  *; }
-dontwarn com.google.android.gms.**
-dontnote **ILicensingService
-dontnote com.google.android.gms.**
-dontwarn com.google.android.gms.ads.**

########################
# Firebase Crashlytics #
########################
-renamesourcefileattribute SourceFile
-keepattributes SourceFile, LineNumberTable
-keep public class * extends java.lang.Exception

##############
# Coroutines #
##############
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

#####################
# MEGA SDK Bindings #
#####################
-keep class nz.mega.sdk.** { *; }

#############################
# Retrofit / OkHttp / Moshi #
############################
-keepattributes Signature
-dontwarn org.jetbrains.annotations.**
-keep class kotlin.Metadata { *; }
-keepclassmembers class mega.vpn.android.data.api.model.** {
  <init>(...);
  <fields>;
}
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation