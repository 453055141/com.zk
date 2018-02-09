package com.zk.zkbootsso.service.impl;

import com.zk.zkbootpojo.entity.masterModel.MembersExample;
import com.zk.zkbootpojo.mapper.masterMapper.MembersMapper;
import com.zk.zkbootsso.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MembersMapper membersMapper;

    @Override
    public String loginAuth(String username, String password) {
        MembersExample me = new MembersExample();
        MembersExample.Criteria mec = me.createCriteria();
        mec.andUserNameEqualTo(username);
        return null;
    }
}
