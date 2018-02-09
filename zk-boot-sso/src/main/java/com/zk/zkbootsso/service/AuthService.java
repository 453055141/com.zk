package com.zk.zkbootsso.service;

public interface AuthService {

    /**
     * 登录认证
     * @return
     */
    public String loginAuth(String username,String password);
}
