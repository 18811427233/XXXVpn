package com.demo.xxxvpn.data;

import android.util.Log;

import java.util.concurrent.atomic.AtomicLong;

import timber.log.Timber;

public class UserFlowHelper {

    private static AtomicLong userFlowAtomic;

    private static AtomicLong useFlowAtomic;

    public static void init(long flow) {
        userFlowAtomic = new AtomicLong(flow);
        useFlowAtomic = new AtomicLong(0);
    }

    public static void add(long flow) {
        userFlowAtomic.addAndGet(flow);
    }

    /**
     *
     * @param flow
     * @return is empty
     */
    public static boolean use(long flow) {

        Timber.e(userFlowAtomic.get()+"===Connected===use==111="+(useFlowAtomic.get() - flow));

        long f = userFlowAtomic.addAndGet(useFlowAtomic.get() - flow);

        Timber.e(userFlowAtomic.get()+"===Connected===use==222="+f);
        useFlowAtomic.set(flow);

        Timber.e(userFlowAtomic.get()+"===Connected===use==333=");

        if (f < 0) {
            userFlowAtomic.set(0);
            return true;
        }
        return false;
    }
    public static long useFlow(long flow) {

        long f = userFlowAtomic.addAndGet(useFlowAtomic.get() - flow);
        useFlowAtomic.set(flow);

        if (f < 0) {
            userFlowAtomic.set(0);
            return 0;
        }

        return userFlowAtomic.get();
    }

    public static boolean empty() {
        return userFlowAtomic.get() <= 0;
    }

    public static void clearUseFlow() {
        useFlowAtomic.set(0);
    }

    public static long getUserFlow() {
        return userFlowAtomic.get();
    }
}
