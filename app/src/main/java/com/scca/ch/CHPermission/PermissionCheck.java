package com.scca.ch.CHPermission;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;

import com.scca.ch.Basetool.LogUtils;

/**
 * @Author Jack.Zhou
 * @Description
 * @Date: 2018-12-6
 */
public class PermissionCheck {


    /**
     *  权限检查
     * @param activity
     * @return
     */
    public static Boolean checkPermission(Activity activity){
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                LogUtils.debug("开始动态申请权限");
                boolean hasPermission = true;
                for (String s : PERMISSION_CODE) {
                    if(ContextCompat.checkSelfPermission(activity, s) == PackageManager.PERMISSION_DENIED){
                        LogUtils.debug("权限["+s+"]还没有获取，需要进行权限获取");
                        hasPermission = false;
                        break;
                    }
                }
                if(!hasPermission){
                    activity.requestPermissions(PERMISSION_CODE,PERMISSION_REQUEST_CODE);
                }
                return hasPermission;
            }
        }catch(Exception ex){
            LogUtils.debug("授权失败:" + ex.getMessage());
            return false;
        }
        return true;
    }


    private static final String[] PERMISSION_CODE = {

            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    public static final int PERMISSION_REQUEST_CODE = 10990;

}
