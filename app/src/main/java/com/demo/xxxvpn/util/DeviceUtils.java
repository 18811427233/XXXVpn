package com.demo.xxxvpn.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;

import java.util.UUID;

public class DeviceUtils {

    private static String DeviceId = "";

    public static String getDeviceId(Context context) {

        if (DeviceId.length()==0) {
            DeviceId = getUniquePsuedoID() + getAndroidId(context);

        }

        return MD5Utils.MD5(DeviceId);
    }

    public static String getRandomCode(int num) {
        String randomcode = "";
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < num; j++) {
            char c = m[(int) (Math.random() * 36)];
            if (randomcode.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            randomcode = randomcode + c;
        }
        return randomcode;
    }

    public static String getModel() {
        String model = Build.MODEL;
        if (model != null) {
            model = model.trim().replaceAll("\\s*", "");
        } else {
            model = "";
        }
        return model;
    }

    /**
     * Return the version name of device's system.
     *
     * @return the version name of device's system
     */
    public static String getSDKVersionName() {
        return Build.VERSION.RELEASE;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getUniquePsuedoID() {
        String m_szDevIDShort = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        String serial = null;
        try {
            serial = Build.class.getField("SERIAL").get(null).toString();
            UUID uuid = new UUID(m_szDevIDShort.hashCode(), serial.hashCode());
            return uuid.toString();
        } catch (Exception exception) {
            serial = "serial";
        }
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }

    @SuppressLint("HardwareIds")
    public static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Throwable e) {
            return "";
        }
    }


}
