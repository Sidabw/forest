/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: SysModel
 * Author:   feiyi
 * Date:     2019/7/17 10:36 AM
 * Description: 系统模块
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.zenki.modelPlatform.sysmodels;

/**
 * 〈一句话功能简述〉: 
 * 〈系统模块〉
 *
 * @author feiyi
 * @create 2019/7/17
 * @since 1.0.0
 */
public interface SysModel {

    void init(Object object);

    Object process(Object object) throws Exception;

}
