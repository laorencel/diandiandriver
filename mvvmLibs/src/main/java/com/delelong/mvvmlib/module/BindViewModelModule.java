package com.delelong.mvvmlib.module;

import com.delelong.mvvmlib.view.iview.BindViewModel;
import com.delelong.mvvmlib.viewmodel.ViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/4/10.
 */
@Module
public class BindViewModelModule {

    BindViewModel bindViewModel;

    public BindViewModelModule(BindViewModel bindViewModel) {
        this.bindViewModel = bindViewModel;
    }

    @Provides
    ViewModel providesViewModel(){
        return bindViewModel.onBindViewModel();
    }
}
