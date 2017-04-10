package com.delelong.mvvmlib.viewmodel.iviewmodel;

import com.delelong.mvvmlib.bean.Result;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/4/8.
 */

public interface IRetrofitViewModel<Data> {

//    /**
//     * 设置对应的接口文件
//     * @param retrofit
//     * @return
//     */
//    Class<ApiServer> setApiService(Retrofit retrofit);
//
//    /**
//     * 设置接口方法请求数据
////     * @param apiServer
//     * @return
//     */
//    Observable getApiData(Class<ApiServer> tClass);

    /**
     * 设置对应的接口文件
     * @param retrofit
     * @return
     */
    Observable setApiInterface(Retrofit retrofit);

    /**
     * 通知model的enqueue方法把请求添加到请求队列中
     */
    void enqueue();

    /**
     * 通知model层取消对应的请求
     */
    void cancel();

    /**
     * Model层回调的数据
     * @param result
     */
    void onResult(Result<Data> result);

    /**
     * 请求成功
     */
    void onSuccess();

    /**
     * 网络错误
     * @param e
     */
    void onNetworkError(Throwable e);

    /**
     * showProgress
     * @param enable
     */
    void showProgress(boolean enable);
}
