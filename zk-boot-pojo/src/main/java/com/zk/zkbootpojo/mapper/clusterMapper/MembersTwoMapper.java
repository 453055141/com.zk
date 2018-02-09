package com.zk.zkbootpojo.mapper.clusterMapper;

import com.zk.zkbootpojo.entity.clusterModel.MembersTwo;
import com.zk.zkbootpojo.entity.clusterModel.MembersTwoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MembersTwoMapper {
    int countByExample(MembersTwoExample example);

    int deleteByExample(MembersTwoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MembersTwo record);

    int insertSelective(MembersTwo record);

    List<MembersTwo> selectByExample(MembersTwoExample example);

    MembersTwo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MembersTwo record, @Param("example") MembersTwoExample example);

    int updateByExample(@Param("record") MembersTwo record, @Param("example") MembersTwoExample example);

    int updateByPrimaryKeySelective(MembersTwo record);

    int updateByPrimaryKey(MembersTwo record);
}