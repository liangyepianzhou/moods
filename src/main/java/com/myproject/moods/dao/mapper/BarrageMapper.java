package com.myproject.moods.dao.mapper;

import com.myproject.moods.pojo.Barrage;
import com.myproject.moods.pojo.BarrageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BarrageMapper {
    long countByExample(BarrageExample example);

    int deleteByExample(BarrageExample example);

    int deleteByPrimaryKey(Long barId);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    List<Barrage> selectByExample(BarrageExample example);

    Barrage selectByPrimaryKey(Long barId);

    int updateByExampleSelective(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByExample(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);
}