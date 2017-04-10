package com.delelong.mvvmlib.component;

import com.delelong.mvvmlib.module.BindViewModelModule;
import com.delelong.mvvmlib.view.MvvmActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/4/10.
 */
@Component(modules = {BindViewModelModule.class})
public interface MvvmActivityComponent {

    void inject(MvvmActivity mvvmActivity);

}
