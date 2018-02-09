package com.zk.zkbootpojo.mapper.masterMapper;

import com.zk.zkbootpojo.entity.masterModel.Members;
import com.zk.zkbootpojo.entity.masterModel.MembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MembersMapper {
    int countByExample(MembersExample example);

    int deleteByExample(MembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Members record);

    int insertSelective(Members record);

    List<Members> selectByExample(MembersExample example);

    Members selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Members record, @Param("example") MembersExample example);

    int updateByExample(@Param("record") Members record, @Param("example") MembersExample example);

    int updateByPrimaryKeySelective(Members record);

    int updateByPrimaryKey(Members record);
}