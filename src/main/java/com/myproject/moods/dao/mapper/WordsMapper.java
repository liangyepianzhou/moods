package com.myproject.moods.dao.mapper;

import com.myproject.moods.pojo.Words;
import com.myproject.moods.pojo.WordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WordsMapper {
    long countByExample(WordsExample example);

    int deleteByExample(WordsExample example);

    int deleteByPrimaryKey(Byte wordId);

    int insert(Words record);

    int insertSelective(Words record);

    List<Words> selectByExample(WordsExample example);

    Words selectByPrimaryKey(Byte wordId);

    int updateByExampleSelective(@Param("record") Words record, @Param("example") WordsExample example);

    int updateByExample(@Param("record") Words record, @Param("example") WordsExample example);

    int updateByPrimaryKeySelective(Words record);

    int updateByPrimaryKey(Words record);
}