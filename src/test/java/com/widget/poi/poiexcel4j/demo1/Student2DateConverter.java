/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Student2DateConverter
 * Author:   feiyi
 * Date:     2019/4/15 11:51 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.poi.poiexcel4j.demo1;

import com.github.crab2died.converter.ReadConvertible;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 〈一句话功能简述〉:
 * 〈读转换器〉
 *
 * @author feiyi
 * @create 2019/4/15
 * @since 1.0.0
 */
public class Student2DateConverter implements ReadConvertible {

    @Override
    public Object execRead(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
