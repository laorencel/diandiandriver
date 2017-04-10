package com.delelong.mvvmlib.view.iview;

import com.delelong.mvvmlib.viewmodel.ViewModel;

/**
 * Created by Administrator on 2017/4/10.
 */

public interface BindViewModel {

    /**
     * 必须在该方法中生成ViewModel实例
     * @return 绑定ViewModel
     */
    ViewModel onBindViewModel();

    /**
     * 初始化操作
     */
    void init();
}
