package com.delelong.mvvmlib.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * 所有Activity基类
 * Created by Administrator on 2017/4/8.
 */

public abstract class BaseActivity extends AppCompatActivity{


    @Override
    public void startActivity(Intent intent) {
        try{
            super.startActivity(intent);
        }catch (ActivityNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        try{
            super.startActivityForResult(intent, requestCode);
        }catch (ActivityNotFoundException e){
            e.printStackTrace();
        }
    }
}
