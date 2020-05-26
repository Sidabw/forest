/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/8/28 2:59 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.personal.bj;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.io.*;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/8/28
 * @since 1.0.0
 */
public class Demo {

    @Test
    public void test1 () throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/feiyi/Desktop/jinjing.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/feiyi/Desktop/jinjing2.txt")));
        String line ;
        while ((line = bufferedReader.readLine()) != null) {
            if (StringUtils.isEmpty(line))
                continue;
            else
                bufferedWriter.write(line);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    @Test
    public void test2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/feiyi/Desktop/jinjing2.txt")));
        String line;
        String allLine = "";
        while((line = bufferedReader.readLine()) != null) {
            allLine +=line;
        }
        String substring = allLine.substring(7, allLine.length() - 3);
        substring += "]";

//        System.out.println(substring.length());
//        System.out.println("-------------------------------------------");
//        int commentIndexStart;
//        int commentIndexEnd;
//        while ( (commentIndexStart = substring.indexOf("<!--")) != -1) {
//            commentIndexEnd = substring.indexOf("-->");
//            System.out.println(commentIndexStart);
//            System.out.println(commentIndexEnd);
//            System.out.println("-------------------------------------------");
//            String part1 = substring.substring(0, commentIndexStart);
//            String part2 = substring.substring(commentIndexEnd + 3);
//            substring = part1 + part2;
//        }

        substring = substring.replaceAll("<!--", "");

//        System.out.println(substring.substring(2320, 2700));
        JSONArray array = JSONArray.parseArray(substring);
        System.out.println(array.size());
    }
}
