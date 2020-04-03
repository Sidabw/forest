package com.beta.widgets.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 *  Created by shao.guangze on 2018/8/22
 */
@Controller
@RequestMapping("/secuser")
public class UserController {

    @RequestMapping("/test")
    @ResponseBody
    public String userAuthority(){
        return "userAuthority";
    }
}
