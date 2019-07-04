/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo2
 * Author:   feiyi
 * Date:     2019/7/4 11:58 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.test;

import java.text.SimpleDateFormat;
        import java.util.Date;
import java.util.TimeZone;

public class Demo2 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
