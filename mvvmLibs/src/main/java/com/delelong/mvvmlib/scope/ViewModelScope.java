package com.delelong.mvvmlib.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017/4/9.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelScope {
}
