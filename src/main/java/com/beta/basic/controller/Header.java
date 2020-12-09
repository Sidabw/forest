/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Header
 * Author:   feiyi
 * Date:     2020/11/1 1:50 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/11/1
 * @since 1.0.0
 */
@Data
public class Header {

    public Header(String c1, String c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Header() {
    }

    String c1;

    String c2;
}
