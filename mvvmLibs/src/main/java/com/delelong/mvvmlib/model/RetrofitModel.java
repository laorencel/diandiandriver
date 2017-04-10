package com.delelong.mvvmlib.model;

import android.text.TextUtils;

import com.delelong.mvvmlib.bean.Result;
import com.delelong.mvvmlib.component.DaggerRetrofitModelComponent;
import com.delelong.mvvmlib.constants.ServerManager;
import com.delelong.mvvmlib.model.imodel.IRetrofitModel;
import com.delelong.mvvmlib.module.RetrofitModule;
import com.delelong.mvvmlib.network.BaseParamsInterceptor;
import com.delelong.mvvmlib.viewmodel.iviewmodel.IRetrofitViewModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/4/8.
 */

public class RetrofitModel implements IRetrofitModel {

    Disposable disposable;

    Observable observable;

    @Inject
    Retrofit retrofit;

    @Inject
    BaseParamsInterceptor.Builder builder;

    private IRetrofitViewModel viewModel;

    private Scheduler resultScheduler;

    private String url;
    private int defaultTimeOut = 15;

    public RetrofitModel(IRetrofitViewModel viewModel) {
        this.viewModel = viewModel;
        this.resultScheduler = AndroidSchedulers.mainThread();
        if (!TextUtils.isEmpty(resetServerAddress())) {
            url = resetServerAddress();
        } else {
            url = ServerManager.getServerAddress();
        }
        if (TextUtils.isEmpty(url)) {
            throw new NullPointerException("url can be not null");
        }

        DaggerRetrofitModelComponent
                .builder()
                .retrofitModule(new RetrofitModule(url, defaultTimeOut))
                .build()
                .inject(this);

    }

    @Override
    public void enqueueRequest() {

        observable = viewModel.setApiInterface(retrofit);
        observable.subscribeOn(Schedulers.io())
                .observeOn(resultScheduler)
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(Result result) {
                        viewModel.onResult(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        viewModel.onNetworkError(e);
                    }

                    @Override
                    public void onComplete() {
                        viewModel.showProgress(false);
                    }
                });
    }

    public Disposable getDisposable() {
        return disposable;
    }

    public void setDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    @Override
    public void cancelRequest() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void setResultSchedule(Scheduler scheduler) {
        resultScheduler = scheduler;
    }

    @Override
    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public BaseParamsInterceptor.Builder getBuilder() {
        return builder;
    }

    @Override
    public String resetServerAddress() {
        return null;
    }
}
