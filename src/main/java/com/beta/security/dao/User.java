package com.beta.security.dao;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public class User implements Serializable/*, UserDetails*/ {
    private Integer id;

    private String userName;

    private String password;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回用户权限
        return Arrays.asList( new SimpleGrantedAuthority("USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        //账户是否会过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //用户是否被锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //密码是否会国企
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}