package com.demo.xxxvpn.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.demo.xxxvpn.constant.Constant;


public class SharedPreferencesUtils {

    public static final String DEFAULT_STRING = "";
    private static volatile SharedPreferencesUtils sharedPreferencesUtils;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPreferencesUtils(Context context) {
        if (context != null) {
            sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.SP_KEY_PATH, 0);
            editor = sharedPreferences.edit();
        }
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        if (sharedPreferencesUtils == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (sharedPreferencesUtils == null) {
                    sharedPreferencesUtils = new SharedPreferencesUtils(context);
                }
            }
        }
        return sharedPreferencesUtils;
    }


    public void putString(String key, String value) {
        if (editor != null) {
            editor.putString(key, value);
            editor.commit();
        }
    }

    public String getString(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, DEFAULT_STRING);
        } else {
            return "";
        }
    }

    public boolean getBoolean(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(key, false);
        } else {
            return false;
        }
    }

    public void putBoolean(String key, boolean value) {
        if (editor != null) {
            editor.putBoolean(key, value);
            editor.commit();
        }
    }

    public void putInt(String key, int value) {
        if (editor != null) {
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public int getInt(String key, int defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(key, defaultValue);
        } else {
            return 0;
        }
    }
    public int getInt(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(key, 0);
        } else {
            return 0;
        }
    }

    public long getLong(String key, int defaultValue) {
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(key, defaultValue);
        } else {
            return 0;
        }
    }

    public long getLong(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(key, 0);
        } else {
            return 0;
        }
    }

    public void putLong(String key, long value) {
        if (editor != null) {
            editor.putLong(key, value);
            editor.commit();
        }
    }

    public void removeKey(String key) {
        if (editor != null) {
            editor.remove(key);
            editor.commit();
        }
    }

}
