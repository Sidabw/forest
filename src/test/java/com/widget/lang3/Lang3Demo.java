/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Lang3Demo Author:   shaogz Date:     2021/4/21 2:53 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.lang3;

import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/4/21
 * @since 1.0.0
 */
public class Lang3Demo {

    private static final DateParser DATE_PARSER = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");


    public static void main(String[] args) throws ParseException {

        Date messageTimeDate = DATE_PARSER.parse("dddd");

    }
}
