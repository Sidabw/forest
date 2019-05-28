/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: UserServiceImpl
 * Author:   feiyi
 * Date:     2019/5/23 9:10 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.gp.service.impl;

import com.beta.widgets.gp.dao.GpUser;
import com.beta.widgets.gp.dao.GpUserExample;
import com.beta.widgets.gp.dao.GpUserMapper;
import com.beta.widgets.gp.service.IGpUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/5/23
 * @since 1.0.0
 */
//@Resource(name = "gpUserService")
public class GpUserServiceImpl implements IGpUserService {

    @Autowired
    private GpUserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        String md5password = DigestUtils.md5Hex(password);
        GpUserExample example = new GpUserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(md5password);
        List<GpUser> gpUsers = userMapper.selectByExample(example);
        return !CollectionUtils.isEmpty(gpUsers);
    }

    @Override
    public boolean regist(String username, String password, String realname, String groupCode) {
        String md5password = DigestUtils.md5Hex(password);
        GpUser gpUser = new GpUser();
        gpUser.setUsername(username);
        gpUser.setPassword(md5password);
        gpUser.setRealname(realname);
        gpUser.setGroupCode(groupCode);
        int insert = userMapper.insert(gpUser);
        return insert == 1 ? true : false;
    }
}
