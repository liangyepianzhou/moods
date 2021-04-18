package com.myproject.moods.dao.mapper;

import com.myproject.moods.pojo.Looksays;
import com.myproject.moods.pojo.LooksaysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LooksaysMapper {
    long countByExample(LooksaysExample example);

    int deleteByExample(LooksaysExample example);

    int insert(Looksays record);

    int insertSelective(Looksays record);

    List<Looksays> selectByExample(LooksaysExample example);

    int updateByExampleSelective(@Param("record") Looksays record, @Param("example") LooksaysExample example);

    int updateByExample(@Param("record") Looksays record, @Param("example") LooksaysExample example);
}