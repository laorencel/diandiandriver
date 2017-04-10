package com.delelong.mvvmlib.component;


import com.delelong.mvvmlib.databinding.ContentMvvmBinding;
import com.delelong.mvvmlib.module.ViewModelModule;
import com.delelong.mvvmlib.scope.ViewModelScope;
import com.delelong.mvvmlib.wrapper.ViewModelWrapper;

import dagger.Component;

/**
 * 为ViewModelWrapper提供注入
 */
@ViewModelScope
@Component(modules = ViewModelModule.class)
public interface ViewModelComponent {

    void inject(ViewModelWrapper viewModelWrapper);

    ContentMvvmBinding getContentMvvmBinding();

}
