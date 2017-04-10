package com.delelong.mvvmlib.viewmodel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;

import com.delelong.mvvmlib.R;
import com.delelong.mvvmlib.bean.Result;
import com.delelong.mvvmlib.bean.TitleBean;
import com.delelong.mvvmlib.component.DaggerViewModelComponent;
import com.delelong.mvvmlib.databinding.ActivityMvvmBinding;
import com.delelong.mvvmlib.model.imodel.IErrorModel;
import com.delelong.mvvmlib.model.imodel.IViewModel;
import com.delelong.mvvmlib.module.ViewModelModule;
import com.delelong.mvvmlib.view.MvvmActivity;
import com.delelong.mvvmlib.wrapper.ViewModelWrapper;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/4/9.
 */

public abstract class ViewModel implements IViewModel, IErrorModel {

    private static final String TAG = "BAIDUMAPMVVM";
    private boolean isSuccess;
    @Inject
    TitleBean titleBean;
    /**
     * Activity/Fragment
     */
    private Context context;
    ActivityMvvmBinding activityMvvmBinding;
    @Inject
    ViewModelWrapper viewModelWrapper;

    public ViewModel(MvvmActivity activity) {
        this.context = activity;

        initActivity(activity);
    }

    private void initActivity(MvvmActivity activity) {
        activityMvvmBinding =
                DataBindingUtil.setContentView(activity, R.layout.activity_mvvm);

        DaggerViewModelComponent
                .builder()
                .viewModelModule(new ViewModelModule(this, context, activityMvvmBinding))
                .build()
                .inject(viewModelWrapper);

        init();
    }

    @Override
    public void init() {
        viewModelWrapper.titleMvvmBinding.setTitleBean(titleBean);
    }

    public void setTitle(String title) {
        titleBean.title.set(title);
    }

    @Override
    public void enqueue() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void onResult(Result result) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onNetworkError(Throwable e) {

    }

    @Override
    public void showProgress(boolean enable) {

    }

    @Override
    public void onError(int errorCode, String errorStatus, String errorMsg) {

    }

    @Override
    public void setErrorImg(Drawable drawable) {

    }

    @Override
    public void setErrorMsg(String errorMsg) {

    }
}
