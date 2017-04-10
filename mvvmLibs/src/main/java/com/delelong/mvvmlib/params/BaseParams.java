package com.delelong.mvvmlib.params;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 参数基类,继承不能多于两层
 * Created by Administrator on 2017/4/8.
 */

public class BaseParams {
    /**
     * @Method: toMap()
     * @author create by Tang
     * @date date 16/8/23 下午3:20
     * @Description: 把实体类转换成Map类
     */
    public Map<String,String> toMap() {
        Class<? extends BaseParams> clazz = this.getClass();
        Class<? extends Object> superClass = clazz.getSuperclass();

        Field[] fields = clazz.getDeclaredFields();
        Field[] superFields = superClass.getDeclaredFields();

        if (fields == null || fields.length == 0 ){
            return Collections.EMPTY_MAP;
        }

        Map<String, String> params = new HashMap<>();
        try {

            for (Field field : fields) {
                if (field.get(this) != null){
                    field.setAccessible(true);
                    SerializedName paramsName = field.getAnnotation(SerializedName.class);
                    String key;
                    if (paramsName == null){
                        key = field.getName();
                    }else {
                        key = paramsName.value();
                    }
                    params.put(key , String.valueOf(field.get(this)));
                }
            }

            for (Field superField : superFields){
                if (superField.get(this) != null){
                    superField.setAccessible(true);
                    SerializedName superParamsName = superField.getAnnotation(SerializedName.class);
                    String superKey;
                    if (superParamsName == null){
                        superKey = superField.getName();
                    }else {
                        superKey = superParamsName.value();
                    }
                    params.put(superKey, String.valueOf(superField.get(this)));
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return params;
    }


    public String toString(){
        Class<? extends BaseParams> clazz = this.getClass();
        Class<? extends Object> superClass = clazz.getSuperclass();

        Field[] fields = clazz.getDeclaredFields();
        Field[] superFields = superClass.getDeclaredFields();

        if (fields == null || fields.length == 0 ){
            return "Params is null!";
        }

        String toString = "";

        try {

            for (Field field : fields) {
                if (field.get(this) != null){
                    field.setAccessible(true);
                    SerializedName paramsName = field.getAnnotation(SerializedName.class);
                    String key;
                    if (paramsName == null){
                        key = field.getName();
                    }else {
                        key = paramsName.value();
                    }
                    if (!key.equals("serialVersionUID")) {
                        toString += key + " = " + String.valueOf(field.get(this)) + " & ";
                    }
                }
            }

            for (Field superField : superFields){
                if (superField.get(this) != null){
                    superField.setAccessible(true);
                    SerializedName superParamsName = superField.getAnnotation(SerializedName.class);
                    String superKey;
                    if (superParamsName == null){
                        superKey = superField.getName();
                    }else {
                        superKey = superParamsName.value();
                    }
                    if (!superKey.equals("serialVersionUID")){
                        toString += superKey + " = " + String.valueOf(superField.get(this)) + " & ";
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return toString;
    }
}
