package com.demo.xxxvpn.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Random;

public class Utils {

    private static long lastClickTime;

    public static int random(int sum) {
        Random random = new Random();
        return random.nextInt(sum) + 1;

    }

    public static String timeConversion(int time) {
        int hour = 0;
        int minutes = 0;
        int sencond = 0;
        int temp = time % 3600;
        if (time > 3600) {
            hour = time / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    minutes = temp / 60;
                    if (temp % 60 != 0) {
                        sencond = temp % 60;
                    }
                } else {
                    sencond = temp;
                }
            }
        } else {
            minutes = time / 60;
            if (time % 60 != 0) {
                sencond = time % 60;
            }
        }

        return (hour<10?("0"+hour):hour) + ":" + (minutes<10?("0"+minutes):minutes) + ":" + (sencond<10?("0"+sencond):sencond);
    }

    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public static int getVersionCode(Context mContext) {
        int versionCode = 0;
        try {
            versionCode = mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public static boolean isFastDoubleClick() {

        long times = System.currentTimeMillis();
        if (times - lastClickTime < 300) {
            return true;
        }

        lastClickTime = times;

        return false;

    }

    public static boolean netCheck(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();

        boolean isConnected = nInfo != null && nInfo.isConnectedOrConnecting();
        return isConnected;
    }

    private static final int BYTES_IN_KILOBYTE = 1024;
    private static final int KILOBYTES_IN_MEGABYTE = 1024;
    private static final String MEGABYTE_UNIT = " MB";
    private static final String GIGABYTE_UNIT = " GB";

    public static String flowFormat(long flowKb) {

        if (flowKb < 0) {
            return "0.00 MB";
        }

        double value = 0.00;
        String unit = MEGABYTE_UNIT;

        if (flowKb >= BYTES_IN_KILOBYTE * BYTES_IN_KILOBYTE) {
            value = flowKb / (BYTES_IN_KILOBYTE * BYTES_IN_KILOBYTE * 1.0);
            unit = GIGABYTE_UNIT;
        } else {
            value = flowKb / BYTES_IN_KILOBYTE * 1.0;
        }

        return String.format("%.2f", value) + unit;
    }
}
