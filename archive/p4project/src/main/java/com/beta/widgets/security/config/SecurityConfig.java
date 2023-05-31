/*
package com.beta.security.config;

import ISecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*/
package com.beta.widgets.security.config;
/*import com.beta.widgets.spring.security.config.LoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*//***
 *  Created by shao.guangze on 2018/8/21
 *//*

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    *//*@Autowired
    private ISecurityUserService service;*//*

    @Autowired
    private LoginAuthenticationProvider lap;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()    //授权
                //.antMatchers("/**").access("hasRole('USERBREW' or 'ADMINSIDA')")
                .antMatchers("/secuser/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/secadmin/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/sida/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/userSwagger/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/scheduler/**").access("hasRole('ADMINSIDA')")
//                .antMatchers("/beauty1").access("permitAll()")
                .antMatchers("/toLogin").access("permitAll()")
                .antMatchers("/login-resources/**").access("permitAll()")
                .antMatchers("/user/**").access("permitAll()")
                .antMatchers("/user/loginTest").access("permitAll()")
                .antMatchers("/user/upload").access("permitAll()")
                *//*.and()
                .formLogin()
                    .loginPage("/toLogin")
                    .loginProcessingUrl("/user/loginTest")
                    .defaultSuccessUrl("/beauty1")*//*;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.authenticationProvider(lap);
        //auth.userDetailsService(springss);
    }
}*/

