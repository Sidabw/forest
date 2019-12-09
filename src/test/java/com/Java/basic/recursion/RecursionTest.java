/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/4/25 6:06 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.recursion;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉:
 * 〈递归计算两个map是否相同,
 * 如果要比较两个实体类是否相同的话，可以再此基础上JSON序列化转一下〉
 *
 * @author feiyi
 * @create 2019/4/25
 * @since 1.0.0
 */
public class RecursionTest {

    @Test
    public void test(){
        String str1 = " {\n" +
                "                    \"paragraph_offset\" : 4,\n" +
                "                    \"paragraph_location\" : {\n" +
                "                        \"r\" : \"521.64374\",\n" +
                "                        \"b\" : \"702.94\",\n" +
                "                        \"t\" : \"547.02997\",\n" +
                "                        \"l\" : \"79.464\"\n" +
                "                    },\n" +
                "                    \"text_offset\" : 2,\n" +
                "                    \"label\" : 1,\n" +
                "                    \"value\" : \"中国农业银行股份有限公司发行减记型无固定期限资本债券计划\",\n" +
                " \"v2alue\" : \"中国农业银行股份有限公司发行减记型无固定期限资本债券计划\"\n" +
                "                }";
        String str2 = "{\n" +
                "                    \"paragraph_offset\" : 4,\n" +
                "                    \"paragraph_location\" : {\n" +
                "                        \"r\" : \"521.64374\",\n" +
                "                        \"b\" : \"702.94\",\n" +
                "                        \"t\" : \"547.02997\",\n" +
                "                        \"l\" : \"79.464\"\n" +
                "                    },\n" +
                "                    \"text_offset\" : 2,\n" +
                "                    \"label\" : 1,\n" +
                "                    \"value\" : \"中国农业银行股份有限公司发行减记型无固定期限资本债券计划\"\n" +
                "                }";
        Map<String, Object> map1 =JSONObject.parseObject(str1);
        Map<String, Object> map2 =JSONObject.parseObject(str2);

        Boolean aBoolean = recursionCompareMap(map1, map2);
        System.out.println(aBoolean);
    }

    private Boolean recursionCompareMap(Map<String, Object> map1, Map<String, Object> map2){
        Set<String> map1Keyset = map1.keySet();
        Set<String> map2Keyset = map2.keySet();
        if (map1Keyset.size() != map2Keyset.size()) return Boolean.FALSE;

        for (String each : map1Keyset){
            Object objValue1 = map1.get(each);
            Object objValue2 = map2.get(each);
            if (objValue1 == null && objValue2 != null || objValue2 == null && objValue1 != null){
                return Boolean.FALSE;
            }

            if (objValue1 instanceof Map || objValue2 instanceof Map) {
                try {
                    Boolean recursionResult = recursionCompareMap((Map) objValue1, (Map) objValue1);
                    if (!recursionResult) return recursionResult;
                } catch (ClassCastException e) {
                    return Boolean.FALSE;
                }
            }
            if (!objValue1.equals(objValue2)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
