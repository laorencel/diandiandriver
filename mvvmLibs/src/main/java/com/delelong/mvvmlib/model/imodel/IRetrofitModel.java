package com.delelong.mvvmlib.model.imodel;

import com.delelong.mvvmlib.network.BaseParamsInterceptor;

import io.reactivex.Scheduler;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/4/8.
 */

public interface IRetrofitModel {

    /**
     * 添加到请求队列
     */
    void enqueueRequest();

    /**
     * 取消这次请求
     */
    void cancelRequest();

    /**
     * 设置回调事件处理的线程,默认为ui线程
     *
     * @param scheduler
     */
    void setResultSchedule(Scheduler scheduler);

    Retrofit getRetrofit();

    /**
     * okHttp拦截器
     *
     * @return
     */
    BaseParamsInterceptor.Builder getBuilder();

    /**
     * 重设服务器地址
     *
     * @return
     */
    String resetServerAddress();
}
