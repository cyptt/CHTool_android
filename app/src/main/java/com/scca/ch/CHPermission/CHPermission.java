package com.scca.ch.CHPermission;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.scca.ch.Basetool.LogUtils;


public class CHPermission {


    public static Boolean checkPermission(Activity activity,final String[] names){
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                LogUtils.debug("开始动态申请权限");
                boolean hasPermission = true;
                for (String s : names) {
                    if(ContextCompat.checkSelfPermission(activity, s) == PackageManager.PERMISSION_DENIED){
                        LogUtils.debug("权限["+s+"]还没有获取，需要进行权限获取--PERMISSION_DENIED");
                        hasPermission = false;
                        break;
                    }
                }

                if(!hasPermission){
                    activity.requestPermissions(names,PERMISSION_REQUEST_CODE);
                }
                return hasPermission;
            }
        }catch(Exception ex){
            LogUtils.debug("授权失败:" + ex.getMessage());
            return false;
        }
        return true;
    }




    public static final int PERMISSION_REQUEST_CODE = 10190;
}
