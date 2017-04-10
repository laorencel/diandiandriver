package com.delelong.mvvmlib.component;

import com.delelong.mvvmlib.app.MyApplication;
import com.delelong.mvvmlib.module.RetrofitModule;
import com.delelong.mvvmlib.module.SPModule;
import com.delelong.mvvmlib.scope.RetrofitScope;

import dagger.Component;

/**
 * Created by Administrator on 2017/4/8.
 */
@RetrofitScope
@Component(modules = {RetrofitModule.class, SPModule.class})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
