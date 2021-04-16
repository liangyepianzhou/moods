package com.myproject.moods.dao.mapper;

import com.myproject.moods.pojo.Says;
import com.myproject.moods.pojo.SaysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SaysMapper {
    long countByExample(SaysExample example);

    int deleteByExample(SaysExample example);

    int deleteByPrimaryKey(Long sayId);

    int insert(Says record);

    int insertSelective(Says record);

    List<Says> selectByExample(SaysExample example);

    Says selectByPrimaryKey(Long sayId);

    int updateByExampleSelective(@Param("record") Says record, @Param("example") SaysExample example);

    int updateByExample(@Param("record") Says record, @Param("example") SaysExample example);

    int updateByPrimaryKeySelective(Says record);

    int updateByPrimaryKey(Says record);
}