package com.myproject.moods.dao.mapper;

import com.myproject.moods.pojo.Collections;
import com.myproject.moods.pojo.CollectionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionsMapper {
    long countByExample(CollectionsExample example);

    int deleteByExample(CollectionsExample example);

    int deleteByPrimaryKey(@Param("sayId") Long sayId, @Param("username") String username);

    int insert(Collections record);

    int insertSelective(Collections record);

    List<Collections> selectByExample(CollectionsExample example);

    int updateByExampleSelective(@Param("record") Collections record, @Param("example") CollectionsExample example);

    int updateByExample(@Param("record") Collections record, @Param("example") CollectionsExample example);
}