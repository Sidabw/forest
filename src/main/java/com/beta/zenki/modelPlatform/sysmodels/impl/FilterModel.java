/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: FilterModel
 * Author:   feiyi
 * Date:     2019/7/17 10:45 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.zenki.modelPlatform.sysmodels.impl;

import com.alibaba.druid.util.StringUtils;
import com.beta.zenki.modelPlatform.sysmodels.SysModel;

/**
 * 〈一句话功能简述〉:
 * 〈过滤模块〉
 *
 * @author feiyi
 * @create 2019/7/17
 * @since 1.0.0
 */
public class FilterModel implements SysModel {

    private String str = "";

    @Override
    public void init(Object object) {
        str = object.toString();
    }

    @Override
    public Boolean process(Object object) throws Exception {
        if (object == null && StringUtils.isEmpty(str)) return true;
        else if (object == null) return false;
        else if (object.equals(str)) return true;
        else return false;
    }
}
