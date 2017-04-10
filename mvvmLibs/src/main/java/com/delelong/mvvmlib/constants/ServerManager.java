package com.delelong.mvvmlib.constants;

/**
 * Created by Administrator on 2017/4/8.
 */

public class ServerManager {

    //默认发布服务器地址
    private static final String RELEASE_URL = "http://apis.baidu.com/";

    //默认测试服务器地址
    private static final String DEBUG_URL = "http://apis.baidu.com/";

    private static boolean debug = false;

    public static String getServerAddress(){
        if (debug){
            return DEBUG_URL;
        }
        return RELEASE_URL;
    }
}
