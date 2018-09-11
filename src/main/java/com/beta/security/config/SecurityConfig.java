/*
package com.beta.security.config;

import com.beta.security.service.ISecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*/
/***
 *  Created by shao.guangze on 2018/8/21
 *//*

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ISecurityUserService springss;

    @Autowired
    private LoginAuthenticationProvider lap;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .formLogin().loginPage("/login").failureUrl("/loginError").defaultSuccessUrl("/beauty1")
                .and()
                .logout().logoutSuccessUrl("/login").logoutUrl("/logout")
                .and()
                .authorizeRequests()    //授权
                //.antMatchers("/**").access("hasRole('USERBREW' or 'ADMINSIDA')")
                .antMatchers("/secuser/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/secadmin/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/sida/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/userSwagger/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/scheduler/**").access("hasRole('ADMINSIDA')")
                .antMatchers("/beauty1").access("permitAll()")
                .antMatchers("/login").access("permitAll()")
                .antMatchers("/login-resources/**").access("permitAll()")
                .antMatchers("/user/**").access("permitAll()");
                //.antMatchers("/**").access("hasRole('ADMINSIDA')");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("sida").password("123456").roles("ADMINSIDA");
        auth.inMemoryAuthentication().withUser("brew").password("123456").roles("USERBREW");
        auth.authenticationProvider(lap);
        //auth.userDetailsService(springss);
    }
}
*/
