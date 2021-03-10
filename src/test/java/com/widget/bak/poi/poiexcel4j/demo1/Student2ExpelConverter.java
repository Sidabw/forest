/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Student2ExpelConverter
 * Author:   feiyi
 * Date:     2019/4/15 2:06 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.bak.poi.poiexcel4j.demo1;

import com.github.crab2died.converter.WriteConvertible;

/**
 * 〈一句话功能简述〉:
 * 〈写转换器〉
 *
 * @author feiyi
 * @create 2019/4/15
 * @since 1.0.0
 */
public class Student2ExpelConverter implements WriteConvertible {

    @Override
    public Object execWrite(Object o) {
        return o == Boolean.TRUE ? "是" : "否";
    }
}
