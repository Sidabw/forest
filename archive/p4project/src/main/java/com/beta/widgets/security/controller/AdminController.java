package com.beta.widgets.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 *  Created by shao.guangze on 2018/8/22
 */
@Controller
@RequestMapping("/secadmin")
public class AdminController {

    @RequestMapping("/test")
    @ResponseBody
    public String adminAuthority(){
        return "adminAuthority";
    }
}
