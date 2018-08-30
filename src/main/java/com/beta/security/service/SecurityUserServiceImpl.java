package com.beta.security.service;

import com.beta.security.dao.User;
import com.beta.security.dao.UserExample;
import com.beta.security.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  Created by shao.guangze on 2018/8/21
 */
@Service("springss")
public class SecurityUserServiceImpl implements ISecurityUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public void serviceTest() {
        System.out.println("哈哈哈");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() == 0 ){
            throw new UsernameNotFoundException("not-exit");
        }
        return users.get(0);
    }
}
