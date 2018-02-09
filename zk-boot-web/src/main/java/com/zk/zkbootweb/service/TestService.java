package com.zk.zkbootweb.service;

public interface TestService {


    public String finduserinfo(int id);

    /**
     * 抽奖
     * @param userId
     * @return
     */
    public String getPrize(int userId);
}
