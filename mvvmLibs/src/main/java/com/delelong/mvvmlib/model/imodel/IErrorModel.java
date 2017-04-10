package com.delelong.mvvmlib.model.imodel;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017/4/9.
 */

public interface IErrorModel {

    /**
     * 错误处理
     *
     * @param errorCode
     * @param errorStatus
     * @param errorMsg
     */
    void onError(int errorCode, String errorStatus, String errorMsg);

    /**
     * 设置错误显示图片
     *
     * @param drawable
     */
    void setErrorImg(Drawable drawable);

    /**
     * 设置错误显示信息
     *
     * @param errorMsg
     */
    void setErrorMsg(String errorMsg);
}
