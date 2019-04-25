/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ClassOut
 * Author:   feiyi
 * Date:     2019/4/23 6:57 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.controller;

import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/23
 * @since 1.0.0
 */
public class ClassOut {

    private String platId;

    private String type;

    private List<ClassIn> list;

    public String getPlatId() {
        return platId;
    }

    public void setPlatId(String platId) {
        this.platId = platId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ClassIn> getList() {
        return list;
    }

    public void setList(List<ClassIn> list) {
        this.list = list;
    }
}
