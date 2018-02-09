package com.zk.zkbootweb.service;

import com.zk.zkbootpojo.entity.masterModel.Members;

public interface LoginService {
    /**
     * 登录
     * @param
     * @return
     */
    public String login(String username,String password);

    /**
     * 退出
     * @param members
     * @return
     */
    public String logout(Members members);
}
