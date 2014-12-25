package com.example.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-25
 * Time: 下午3:13
 * To change this template use File | Settings | File Templates.
 */
public class DeviceHelper {
    public static boolean isEmulator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        if( imei != null && imei.equals("000000000000000")) return true;
        return  Build.MODEL.equals("sdk") || Build.MODEL.equals("google_sdk") ;
    }
}
