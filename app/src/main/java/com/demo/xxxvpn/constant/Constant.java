package com.demo.xxxvpn.constant;

public class Constant {

    public static final Integer HTTP_SERVICE_UPGRADE = 503;
    public static final Integer HTTP_USER_FLAG = 403;
    public static final Integer HTTP_USER_TOKEN_EXPIRE = 401;
    public static final Integer HTTP_USER_FLOW_EMPTY = 406;
    public static final Integer HTTP_USER_REWARDED_EMPTY = 407;
    public static final Integer HTTP_USER_REWARDED_DIALOG_EMPTY = 408;

    public static final Integer HTTP_USER_SIGN_ERROR = 1001;
    public static final Integer HTTP_USER_SIGN_NOT_START = 1002;
    public static final Integer HTTP_USER_SIGNED = 1003;
    public static final String SP_KEY_SIGN_INTO = "SP_KEY_SIGN_INTO";

    public static final Integer HTTP_USER_NOT_REWARD = 1004;
    public static final Integer HTTP_USER_REWARD_EXPIRED = 1005;
    public static final Integer HTTP_USER_REWARDED_ERROR = 1006;
    public static final Integer HTTP_USER_REWARD_BUSY = 1007;
    public static final Integer HTTP_USER_INVITE_LIMIT = 1011;
    public static final Integer HTTP_USER_INVITE_SELF = 1010;
    public static final Integer HTTP_USER_INVITE_EMPTY = 1009;

    public static final String WEB_PRIVACY_AGREEMENT = "https://vpn.mirror-box.xyz/policy";
    public static final String WEB_FAQ = "https://vpn.mirror-box.xyz/FAQ";
    public static final String RECEIVER_TIME = "RECEIVER_TIME";
    public static final String SP_KEY_PATH = "XXX_VPN";
    public static final String SP_KEY_NODE_SERVER = "SP_KEY_NODE_SERVER";

    public static final String SP_KEY_USER_TOKEN = "SP_KEY_USER_TOKEN";
    public static final String SP_KEY_APP_SHUNT = "SP_KEY_APP_SHUNT";
    public static final String RECEIVER_USER_SIGN = "RECEIVER_USER_SIGN";
    public static final String SP_KEY_USER_LEVEL = "SP_KEY_USER_LEVEL";

    public static final String SP_KEY_UPDATE_VPN = "SP_KEY_UPDATE_VPN";

    public static final String SP_KEY_USE_INIT = "SP_KEY_use_init";
    public static final String SP_KEY_REWARD_UNIT_ID = "SP_KEY_CURRENT_NODE";
    public static final String SP_KEY_VIDEO_VIEW_UNIT_ID = "SP_KEY_VIDEO_VIEW_UNIT_ID";
    public static final String SP_KEY_NATIVE_DIALOG_UNIT_ID = "SP_KEY_VIDEO_VIEW_UNIT_ID";
    public static final String SP_KEY_FIRST_OPEN = "SP_KEY_FIRST_OPEN";
    public static final String SP_KEY_VPN_UNIT_ID = "SP_KEY_VPN_UNIT_ID";
    public static final String SP_KEY_REWARD_POS = "SP_KEY_REWARD_POS12";


    public static final String SP_KEY_SIGN_REFRESH_TIME = "SP_KEY_SIGN_REFRESH_TIME";
    public static final String SP_KEY_REWARD_CD_TIMER = "SP_KEY_REWARD_CD_TIMER";
    public static final String SP_UPDATE_NO_TIPS = "SP_UPDATE_NO_TIPS";
    public static final String SP_KEY_AD_CLICK_TIMEOUT_CD = "SP_KEY_AD_CLICK_TIMEOUT_CD";
    public static final String SP_KEY_REWARD_CACHE_TIMESTAMP_LIST = "SP_KEY_REWARD_CACHE_TIMESTAMP_LIST";
    public static final String SP_KEY_REWARD_CACHE_COMPLETE = "SP_KEY_REWARD_CACHE_COMPLETE";
    public static final String SP_KEY_AD_CLICK_CURRENT_COUNT = "SP_KEY_AD_CLICK_CURRENT_COUNT";

    //Config
    public static final String SP_KEY_FRIEND_INVITATION_REWARD = "SP_KEY_FRIEND_INVITATION_REWARD";
    public static final String SP_KEY_AD_CLICK_CD = "SP_KEY_AD_CLICK_CD";
    public static final String SP_KEY_BANNER_AD_GONE_TIME = "SP_KEY_BANNER_AD_GONE_TIME";
    public static final String SP_KEY_AD_CLICK_MAX_COUNT = "SP_KEY_AD_CLICK_MAX_COUNT";
    public static final String SP_SYS_VPN_TIMEOUT = "SP_SYS_VPN_TIMEOUT";
    public static final String SP_KEY_REWARD_CD = "SP_KEY_REWARD_CD";
    public static final String SP_KEY_CACHE_OPEN_AD = "SP_KEY_CACHE_OPEN_AD";

    public static final String SP_KEY_REWARD_CACHE_CYCLE = "SP_KEY_REWARD_CACHE_CYCLE";
    public static final String SP_KEY_REWARD_CACHE_CYCLE_NUM = "SP_KEY_REWARD_CACHE_CYCLE_NUM";
    public static final String SP_KEY_REWARD_CACHE_DELAY_TIME = "SP_KEY_REWARD_CACHE_DELAY_TIME";


    public static final String SP_KEY_OPEN_AD_CACHE_TIME = "SP_KEY_OPEN_AD_CACHE_TIME";
    public static final String SP_KEY_REWARD_AD_CACHE_TIME = "SP_KEY_REWARD_AD_CACHE_TIME";
    public static final String SP_KEY_INTERSTITIAL_AD_CACHE_TIME = "SP_KEY_INTERSTITIAL_AD_CACHE_TIME";
    public static final String SP_KEY_REQUEST_ERROR_DOT = "SP_KEY_REQUEST_ERROR_DOT";


    public static final String SP_KEY_FLOW_NOT_NOTIFICATION = "SP_KEY_FLOW_NOT_NOTIFICATION";
    public static final String SP_KEY_SIGN_NOT_NOTIFICATION = "SP_KEY_SIGN_NOT_NOTIFICATION";

    public static final String SP_KEY_LEVEL_INTO = "SP_KEY_LEVEL_INTO";

    public static final String SP_KEY_INVITE_INTO = "SP_KEY_INVITE_INTO";

    public static final String SP_KEY_VPN_CONNECT = "SP_KEY_VPN_CONNECT";
    public static final String SP_KEY_CURRENT_ACTIVITY_ID = "SP_KEY_CURRENT_ACTIVITY_ID";
    public static final String SP_KEY_REQUEST_INFO = "SP_KEY_REQUEST_INFO";

    //----------------------DataCenter SP key--------------------
    public static final String DATACENTER_RESOURCE_FLOWS = "resourceFlows";
    public static final String DATACENTER_USED_FLOWS = "usedFlows";
    public static final String DATACENTER_UPLOAD_FLOWS = "uploadFlows";
    public static final String DATACENTER_REWARD_FLOWS = "rewardFlows";
    public static final String DATACENTER_DOT_VPN = "dotVpn";
    public static final String DATACENTER_REWARD_COUNT = "rewardCount";
    public static final String DATACENTER_REWARD_NAME = "rewardName";
    public static final String DATACENTER_REWARD_CD_TIMER_TIMESTAMP = "rewardCdTimerTimestamp";
    public static final String DATACENTER_VPN_TIMER_TIMESTAMP = "vpnTimerTimestamp";
    public static final String DATACENTER_VPN_START_TIMESTAMP = "vpnStartTimestamp";
    public static final String DATACENTER_VPN_START_TIMESTAMP_INIT = "vpnStartTimestampInit";
    public static final String DATACENTER_VPN_STATUS_ENUM = "vpnStatusEnum";
    public static final String DATACENTER_SIGN_START_TIME = "signStartTime";
    public static final String DATACENTER_SIGN_END_TIME = "signEndTime";
    public static final String DATACENTER_SIGN_NUM = "signNum";
    public static final String DATACENTER_SIGN_TOTAL_NUM = "signTotalNum";

    //====================activity result code====================
    public static final Integer MAIN_RESULT_CODE = 0x12;
    public static final Integer MAIN_RESULT_NODE_CODE = 0x13;
    public static final String SIGN_BACK_MAIN = "SIGN_BACK_MAIN";
    public static final String SIGN_LOAD_AD = "SIGN_LOAD_AD";

    //===========BroadcastReceiver==============
    public static final String RECEIVER_CURRENT_TIMER = "RECEIVER_CURRENT_TIMER";
    public static final String RECEIVER_UPDATE_VPN = "RECEIVER_UPDATE_VPN";
    public static final String RECEIVER_CONNECT_ERROR = "RECEIVER_CONNECT_ERROR";
    public static final String RECEIVER_FLOW_EMPTY = "RECEIVER_FLOW_EMPTY";
    public static final String RECEIVER_RETURN_NOTIFICATION = "RECEIVER_RETURN_NOTIFICATION";
    public static final String RECEIVER_SET_SIGN_ALARM = "RECEIVER_SET_SIGN_ALARM";
    public static final String RECEIVER_INVITE_NOTIFICATION = "RECEIVER_INVITE_NOTIFICATION";

    //===========facebook event==============
    public static final String FACEBOOK_EVENT_VPN_CONNECT = "vpn_connect";
    public static final String FACEBOOK_EVENT_REWARD_BUTTON_CLICK = "reward_button_click";

    // ====================MaxAdID=============
    public static final String OPEN_UNIT_ID = "c96726a4c1cc8555";
    public static final String BANNER_UNIT_ID = "727b3a36bf7173a0";
    public static final String INTERSTITIAL_UNIT_ID = "10d409d923144a3e";
    public static final String REWARDED_UNIT_ID = "1aa1eb5f2a6f7ccf";
    public static final String NATIVE_SIGN_UNIT_ID = "9b495dcd003da0e2";


}
