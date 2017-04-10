package com.delelong.mvvmlib.wrapper;

import android.app.ProgressDialog;
import android.databinding.ViewDataBinding;

import com.delelong.mvvmlib.bean.ErrorBean;
import com.delelong.mvvmlib.bean.ProgressBean;
import com.delelong.mvvmlib.databinding.ActivityMvvmBinding;
import com.delelong.mvvmlib.databinding.ContentMvvmBinding;
import com.delelong.mvvmlib.databinding.DefaultProgressBinding;
import com.delelong.mvvmlib.databinding.ErrorBinding;
import com.delelong.mvvmlib.databinding.TitleMvvmBinding;
import com.delelong.mvvmlib.model.imodel.IRetrofitModel;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2017/4/10.
 */

public class ViewModelWrapper {

    @Inject
    public ProgressBean progress;

    @Inject
    public ErrorBean error;

    @Inject
    public IRetrofitModel model;

    @Inject
    public ActivityMvvmBinding activityMvvmBinding;

    @Inject
    public TitleMvvmBinding titleMvvmBinding;

    @Inject
    public ContentMvvmBinding contentMvvmBinding;

    @Named("titleBinding")
    @Inject
    public ViewDataBinding titleBinding;

    @Named("childBinding")
    @Inject
    public ViewDataBinding childBinding;

    @Inject
    public DefaultProgressBinding defaultProgressBinding;

    @Inject
    public ErrorBinding errorBinding;

    @Inject
    public ProgressDialog progressDialog;

    @Inject
    public ViewModelWrapper() {
    }
}
