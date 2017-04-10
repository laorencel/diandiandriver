package com.delelong.mvvmlib.bean;

import android.databinding.ObservableField;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/4/10.
 */

public class TitleBean {
    public ObservableField<String> title = new ObservableField<>();

    @Inject
    public TitleBean() {
    }

    public TitleBean(ObservableField<String> title) {
        this.title = title;
    }
}
