package com.delelong.mvvmlib.component;

import com.delelong.mvvmlib.model.RetrofitModel;
import com.delelong.mvvmlib.module.RetrofitModule;
import com.delelong.mvvmlib.scope.RetrofitScope;

import dagger.Component;

/**
 * Created by Administrator on 2017/4/8.
 */
@RetrofitScope
@Component(modules = {RetrofitModule.class})
public interface RetrofitModelComponent {

    void inject(RetrofitModel retrofitModel);

}
