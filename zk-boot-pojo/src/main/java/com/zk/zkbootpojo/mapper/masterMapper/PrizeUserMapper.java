package com.zk.zkbootpojo.mapper.masterMapper;

import com.zk.zkbootpojo.entity.masterModel.PrizeUser;
import com.zk.zkbootpojo.entity.masterModel.PrizeUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrizeUserMapper {
    int countByExample(PrizeUserExample example);

    int deleteByExample(PrizeUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrizeUser record);

    int insertSelective(PrizeUser record);

    List<PrizeUser> selectByExample(PrizeUserExample example);

    PrizeUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrizeUser record, @Param("example") PrizeUserExample example);

    int updateByExample(@Param("record") PrizeUser record, @Param("example") PrizeUserExample example);

    int updateByPrimaryKeySelective(PrizeUser record);

    int updateByPrimaryKey(PrizeUser record);
}