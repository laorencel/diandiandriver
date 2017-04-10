package com.delelong.mvvmlib.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.delelong.mvvmlib.app.MyApplication;

import dagger.Module;
import dagger.Provides;

/**
 * SharedPreference
 * Created by Administrator on 2017/4/9.
 */
@Module
public class SPModule {
    MyApplication myApplication;

    public SPModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    SharedPreferences providesSP(){
        return myApplication.getSharedPreferences("sp", Context.MODE_PRIVATE|Context.MODE_MULTI_PROCESS);
    }
}
