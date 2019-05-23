/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: IUserService
 * Author:   feiyi
 * Date:     2019/5/23 9:09 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.gp.service;

/**
 * 〈一句话功能简述〉: 
 * 〈〉
 *
 * @author feiyi
 * @create 2019/5/23
 * @since 1.0.0
 */
public interface IUserService {
    boolean login(String username, String passwrod);

    boolean regist(String username, String password, String realname, String groupCode);
}
