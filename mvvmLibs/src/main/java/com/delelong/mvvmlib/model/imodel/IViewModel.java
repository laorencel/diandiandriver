package com.delelong.mvvmlib.model.imodel;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.delelong.mvvmlib.viewmodel.iviewmodel.IRetrofitViewModel;

/**
 * Created by Administrator on 2017/4/9.
 */

public interface IViewModel<Data> extends IRetrofitViewModel<Data> {

    /**
     * 创建toolbar子布局
     * @param inflater
     * @param parent
     * @return
     */
    ViewDataBinding onCreateToolbarBinding(LayoutInflater inflater,ViewGroup parent);

    /**
     * 创建子布局
     * @param inflater
     * @param parent
     * @return
     */
    ViewDataBinding onCreateChildBinding(LayoutInflater inflater, ViewGroup parent);

    /**
     * 初始化操作
     */
    void init();
}
