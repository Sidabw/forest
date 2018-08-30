package com.beta.security.service;

import com.beta.security.dao.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/***
 *  Created by shao.guangze on 2018/8/21
 */
public interface ISecurityUserService extends UserDetailsService {

    boolean saveUser(User user);

    void serviceTest();
}
