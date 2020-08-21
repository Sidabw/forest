/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo2
 * Author:   feiyi
 * Date:     2019/6/24 4:19 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.bak.spirng;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/6/24
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/a")
public class Demo2 {

    @RequestMapping(value = "/b")
    public Object dyReqTest() {
        BigDecimal.valueOf(0.0001).doubleValue();
        return "ooooo------ooooo";
    }
}
