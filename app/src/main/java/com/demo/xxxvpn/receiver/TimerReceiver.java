package com.demo.xxxvpn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import timber.log.Timber;

public class TimerReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        Timber.e("-----1111-----");
        if (intent.getAction().equals("rewardCd")) {
            Timber.e("-----2222-----");
            Intent intent1 = new Intent("rewardCdUpdate");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent1);

        }

    }
}
