package com.zk.zkbootweb.service.impl;

import com.zk.zkbootpojo.entity.clusterModel.MembersTwo;
import com.zk.zkbootpojo.entity.masterModel.Members;
import com.zk.zkbootpojo.entity.masterModel.Prize;


import com.zk.zkbootpojo.mapper.clusterMapper.MembersTwoMapper;
import com.zk.zkbootpojo.mapper.masterMapper.MembersMapper;
import com.zk.zkbootpojo.mapper.masterMapper.PrizeMapper;
import com.zk.zkbootpojo.mapper.masterMapper.PrizeUserMapper;
import com.zk.zkbootweb.Utils.DrawLotteryUtil;
import com.zk.zkbootweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Cacheable("user")
public class TestServiceImpl implements TestService {

    @Autowired
    private MembersMapper membersMapper;

    @Autowired
    private MembersTwoMapper membersTwoMapper;

    @Autowired
    private PrizeMapper prizeMapper;

    @Autowired
    private PrizeUserMapper prizeUserMapper;


    @Override
    public String finduserinfo(int id) {
       Members me = membersMapper.selectByPrimaryKey(1);
       MembersTwo twome = membersTwoMapper.selectByPrimaryKey(1);
        return me.getUserName()+twome.getUserName();
    }

    @Override
    public String getPrize(int userId) {
        DrawLotteryUtil drawLotteryUtil = new DrawLotteryUtil();
        List<Prize> prizelist = prizeMapper.selectByExample(null);
        for(int i=0;i<100;i++){
            int index = drawLotteryUtil.drawGift(prizelist);
            System.out.println(prizelist.get(index));
        }
        return null;
    }
}
