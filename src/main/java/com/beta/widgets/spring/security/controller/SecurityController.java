/*
package com.beta.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/***
 *  Created by shao.guangze on 2018/8/21
 *//*

@Controller
public class SecurityController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(String error){
        System.out.println("error" + error);
        return "login";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/error")
    public String error(String error){
        System.out.println("ERROR REQUEST IN" + error);
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loginError")
    public String loginError(Model model){
        model.addAttribute("error", "用户名或密码错误");
        return "securityLogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String loginout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }
}
*/
