/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: WebSecurityConfig
 * Author:   feiyi
 * Date:     2019/1/3 下午7:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.security.brew;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.sql.DataSource;*/


/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/1/3
 * @since 1.0.0
 */

//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //1.使用内置用户+默认登录页面
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }*/

    //2.配置自定义登录页跳转 + permit部分URL
    /*protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/login-resources/**").permitAll()
                    .antMatchers("/user/loginTest").permitAll()
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                    .anyRequest().authenticated()   //这里代表所有未匹配URL的都需要认证。
                    .and()
                .formLogin()
                    .loginPage("/toLogin").permitAll(); //这里的permitAll代表所有用户都可以访问我们登录页
        System.out.println(1);
    }*/

    //TODO 3.登出..  最后再看T
    /*protected void configure(HttpSecurity http) throws Exception{
        http
                .logout()
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/beauty1")
                    .invalidateHttpSession(true);


    }*/

    //4.jdbc 验证
   /* @Autowired
    private DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from security_users where username = ?")
                .authoritiesByUsernameQuery("select username, role from security_roles where username = ?");
        System.out.println(11);
    }

    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/beauty1").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/toLogin");
        System.out.println(11);
    }*/

//}
