package com.scca.ch.Basetool;

import android.util.Log;

/**
 * @Author Jack.Zhou
 * @Description
 * @Date: 2018-12-5
 */
public class LogUtils {

    private static final Boolean USE_LOG = Boolean.TRUE;

    private static final String LOG_TAG = "CH_COMMON";

    public static void debug(String message){
        if(USE_LOG){
            Log.d(LOG_TAG,message);
        }
    }

    public static void info(String message){
        if(USE_LOG){
            Log.i(LOG_TAG,message);
        }
    }

    public static void warn(String message){
        if(USE_LOG){
            Log.w(LOG_TAG,message);
        }
    }

}
