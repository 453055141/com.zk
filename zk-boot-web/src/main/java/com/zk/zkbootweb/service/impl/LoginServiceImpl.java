package com.zk.zkbootweb.service.impl;

import com.zk.zkbootpojo.entity.masterModel.Members;
import com.zk.zkbootpojo.entity.masterModel.MembersExample;
import com.zk.zkbootpojo.mapper.masterMapper.MembersMapper;
import com.zk.zkbootweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MembersMapper membersMapper;

    @Override
    public String login(String username,String password) {
        MembersExample me = new MembersExample();
        MembersExample.Criteria mec = me.createCriteria();
        mec.andLoginNameEqualTo(username);
        List<Members> melist = membersMapper.selectByExample(me);

        return null;
    }

    @Override
    public String logout(Members members) {
        return null;
    }
}
