/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/4/19 2:36 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.map;

import org.junit.Test;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Set;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/19
 * @since 1.0.0
 */
public class Demo {

    @Test
    public void test() throws IOException {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("a", "b");
//        map.put("b", "c");
//        map.put("c", "d");
//        Set<String> keySet = map.keySet();

        FileInputStream fis = new FileInputStream("/Users/feiyi/Desktop/MapTest2.java");
        FileOutputStream fos = new FileOutputStream("/Users/feiyi/Desktop/MapTest3.java");
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buff = new byte[4096];
        while(fis.read(buff) !=-1){
            out.write(buff);
        }

        fos.write(out.toString("GBK").getBytes("UTF-8"));

    }
}
