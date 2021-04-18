package com.myproject.moods.dao.mapper;

import com.myproject.moods.pojo.Userm;
import com.myproject.moods.pojo.UsermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsermMapper {
    long countByExample(UsermExample example);

    int deleteByExample(UsermExample example);

    int deleteByPrimaryKey(String username);

    int insert(Userm record);

    int insertSelective(Userm record);

    List<Userm> selectByExample(UsermExample example);

    Userm selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Userm record, @Param("example") UsermExample example);

    int updateByExample(@Param("record") Userm record, @Param("example") UsermExample example);

    int updateByPrimaryKeySelective(Userm record);

    int updateByPrimaryKey(Userm record);
}