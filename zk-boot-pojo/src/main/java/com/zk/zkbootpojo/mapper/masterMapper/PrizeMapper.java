package com.zk.zkbootpojo.mapper.masterMapper;

import com.zk.zkbootpojo.entity.masterModel.Prize;
import com.zk.zkbootpojo.entity.masterModel.PrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrizeMapper {
    int countByExample(PrizeExample example);

    int deleteByExample(PrizeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Prize record);

    int insertSelective(Prize record);

    List<Prize> selectByExample(PrizeExample example);

    Prize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Prize record, @Param("example") PrizeExample example);

    int updateByExample(@Param("record") Prize record, @Param("example") PrizeExample example);

    int updateByPrimaryKeySelective(Prize record);

    int updateByPrimaryKey(Prize record);
}