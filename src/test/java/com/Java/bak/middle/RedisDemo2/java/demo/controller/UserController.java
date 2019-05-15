package com.Java.bak.middle.RedisDemo2.java.demo.controller;

import demo.mapping.TbUser;
import demo.mapping.TbUserExample;
import demo.mapping.TbUserExample.Criteria;
import demo.mapping.TbUserMapper;
import java.io.PrintStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{
  @Autowired
  private TbUserMapper tbUserMapper;
  
  @RequestMapping("/detail")
  public String test()
  {
	  /**
	   * 访问地址：http://localhost:8080/ssmANDredis/user/detail
	   * */
    System.out.println("测试成功否");
    TbUserExample tbUserExample = new TbUserExample();
    tbUserExample.or().andUsernameEqualTo("zhangsan1");
    List<TbUser> list = this.tbUserMapper.selectByExample(tbUserExample);
    for (TbUser user : list) {
      if (user != null) {
        System.out.println(user.getUsername());
      }
    }
    return "helloooo";
  }
}
