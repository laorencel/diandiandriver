package com.delelong.mvvmlib.bean;

import javax.inject.Inject;

/**
 * @author create by Tang
 * @ClassName: ProgressBean
 * @date date 16/11/15 下午5:00
 * @Description: 进度条实体类，用于控制进度条
 */

public class ProgressBean {


    //默认进度条
    public static final int PROGRESS_TYPE_DEFAULT = 1;

    //对话框进度条
    public static final int PROGRESS_TYPE_DIALOG = 2;

    //下拉进度条
    public static final int PROGRESS_TYPE_DROP_DOWN = 3;

    //默认对加载进度条
    public int progressType;

    @Inject
    public ProgressBean() {
    }

}
