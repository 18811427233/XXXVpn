package com.demo.xxxvpn.data;

import android.content.Context;

public class DataCenter {

    private static DataCenter dataCenter;

    private static Context mContext;

    public static DataCenter getInstance(Context context) {
        mContext = context;
        if (dataCenter == null) {

            synchronized (DataCenter.class) {
                if (dataCenter == null) {
                    dataCenter = new DataCenter();
                }
            }
        }
        return dataCenter;
    }

    private long rewardFlows;

    private Integer rewardCount;

    private long rewardCdTimerTimestamp;

    private Double updateReward;

    private long rewardShowTimestamp;
    private String rewardName;

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public long getRewardShowTimestamp() {
        return rewardShowTimestamp;
    }

    public void setRewardShowTimestamp(long rewardShowTimestamp) {
        this.rewardShowTimestamp = rewardShowTimestamp;
    }

    public Double getUpdateReward() {
        return updateReward;
    }

    public void setUpdateReward(Double updateReward) {
        this.updateReward = updateReward;
    }


    public long getRewardFlows() {
        return rewardFlows;
    }

    public void setRewardFlows(long rewardFlows) {
        this.rewardFlows = rewardFlows;
    }

    public Integer getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(Integer rewardCount) {
        this.rewardCount = rewardCount;
    }

    public long getRewardCdTimerTimestamp() {
        return rewardCdTimerTimestamp;
    }

    public void setRewardCdTimerTimestamp(long rewardCdTimerTimestamp) {
        this.rewardCdTimerTimestamp = rewardCdTimerTimestamp;
    }

}
