package com.delelong.mvvmlib.app;

import android.app.Application;

import com.delelong.mvvmlib.component.ApplicationComponent;
import com.delelong.mvvmlib.component.DaggerApplicationComponent;
import com.delelong.mvvmlib.constants.ServerManager;
import com.delelong.mvvmlib.module.RetrofitModule;
import com.delelong.mvvmlib.module.SPModule;
import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/4/8.
 */

public class MyApplication extends Application {

    private static final String TAG = "RxMvvmApplication";
    private static MyApplication myApplication;

    ApplicationComponent component;

    @Inject
    Retrofit retrofit;

    @Inject
    Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        init();
    }

    private void init() {
        component = DaggerApplicationComponent
                .builder()
                .retrofitModule(new RetrofitModule(ServerManager.getServerAddress(), 15))
                .sPModule(new SPModule(this))
                .build();
        component.inject(myApplication);
    }

    public static MyApplication getInstance() {
        return myApplication;
    }

    public ApplicationComponent getApplicationComponent() {
        return component;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Gson getGson() {
        return gson;
    }
}
