package com.delelong.mvvmlib.module;

import android.databinding.ObservableField;
import android.util.Log;

import com.delelong.mvvmlib.internal.ObservableFieldTypeAdapter;
import com.delelong.mvvmlib.network.BaseParamsInterceptor;
import com.delelong.mvvmlib.scope.RetrofitScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author create by Tang
 * @ClassName: RetrofitModule
 * @date date 16/11/11 上午11:27
 * @Description: TODO
 */

@Module
public class RetrofitModule {

    private String serverUrl;

    private int timeout;

    private BaseParamsInterceptor.Builder interceptorBuilder;

    public RetrofitModule(String url, int timeout) {
        this.serverUrl = url;
        this.timeout = timeout;
    }

    @RetrofitScope
    @Provides
    public BaseParamsInterceptor.Builder providesInterceptorBuilder() {
        interceptorBuilder = new BaseParamsInterceptor.Builder();
        return interceptorBuilder;
    }

    @RetrofitScope
    @Provides
    public HttpLoggingInterceptor providesHttpInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                Log.i("BAIDUMAPMVVM", "retrofitBack = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    @RetrofitScope
    @Provides
    public Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(serverUrl)
                .addConverterFactory(initGsonConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }

    @RetrofitScope
    @Provides
    public OkHttpClient initOkHttpClient(BaseParamsInterceptor.Builder builder, HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(builder.build())
                .retryOnConnectionFailure(true)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();
    }

    @RetrofitScope
    @Provides
    public Gson initGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .registerTypeAdapterFactory(TypeAdapters.newFactory(ObservableField.class, new ObservableFieldTypeAdapter()))
                .create();
    }

    private GsonConverterFactory initGsonConverterFactory() {
        return GsonConverterFactory.create(initGson());
    }

}
