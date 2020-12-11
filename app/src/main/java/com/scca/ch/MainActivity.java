package com.scca.ch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.scca.ch.Basetool.LogUtils;
import com.scca.ch.CHPermission.CHPermission;

public class MainActivity extends Activity implements View.OnClickListener{

    private  Button permissionBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUI();



    }

    private void setUI(){

        permissionBtn = findViewById(R.id.permission_btn);
        permissionBtn.setOnClickListener(this);
    }


    private void checkPermission(){
       boolean isOpen = CHPermission.checkPermission(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
       if (isOpen){

       }else {
           CHPermission.checkPermission(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
       }
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LogUtils.debug("grantResultsleng---"+grantResults.length);
        for (int result:grantResults){
            LogUtils.debug("grantResults---"+result);
        }
        //在用户已经拒绝授权的情况下，如果shouldShowRequestPermissionRationale返回false则
        // 可以推断出用户选择了“不在提示”选项，在这种情况下需要引导用户至设置页手动授权
        for (int i =0;i<grantResults.length;++i){
          boolean lastResult=   ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[i]);
          LogUtils.debug("lastResult"+lastResult);
        }

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.permission_btn:
                this.checkPermission();
                break;
            default:break;
        }
    }
}