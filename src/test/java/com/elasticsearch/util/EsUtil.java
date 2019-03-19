/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: EsUtil
 * Author:   feiyi
 * Date:     2019/3/19 11:17 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.elasticsearch.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉:
 * 〈util类包括一下内容：
 * 1。将驼峰命名的实体属性转为下划线分隔〉
 *
 * @author feiyi
 * @create 2019/3/19
 * @since 1.0.0
 */
public class EsUtil {

    public static JSONArray entityToEsRecord(List<?> data){
        JSONArray array = new JSONArray();
        for (Object obj : data){
            Class<?> clazz = obj.getClass();
            JSONObject each = new JSONObject();
            for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
                Field[] declaredFields = clazz.getDeclaredFields();
                Stream.of(declaredFields).forEach(e ->{
                    e.setAccessible(Boolean.TRUE);
                    try {
                        Object value = e.get(obj);
                        String name = renameAttribute(e.getName());
                        if (value != null) {
                            each.put(name, value);
                        }
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                });
            }
            array.add(each);
        }
        System.out.println(array);
        return array;
    }

    private static String renameAttribute(String attributeName){
        char[] chars = attributeName.toCharArray();
        StringBuffer result = new StringBuffer();
        for (char e : chars){
            if (e > 64 && e  < 91){
                String curLowerCaseLetter = String.valueOf(e).toLowerCase();
                result.append("_").append(curLowerCaseLetter);
            } else {
                result.append(e);
            }
        }
        return result.toString();
    }
}
