package com.delelong.mvvmlib.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author create by Tang
 * @ClassName: Result
 * @date date 16/11/11 上午9:48
 * @Description: 服务器返回数据格式
 */

public class Result<Data> {
    @SerializedName(value = "errNum", alternate = {"errno", "error_code"})
    public int errNum;

    @SerializedName(value = "status", alternate = {"errStatus"})
    public String errStatus;

    @SerializedName(value = "errMsg", alternate = {"msg"})
    public String errMsg;

//    @SerializedName(value = "result", alternate = {"reason"})
//    public String content;
    /**
     * @author create by Tang
     * @date date 16/10/12 下午4:18
     * @Description: 兼容不同的情况
     * @restData: 百度api, 天气data
     */
    @SerializedName(value = "data", alternate = {"retData", "categories", "shop", "subjects"})
    public Data data;
}
