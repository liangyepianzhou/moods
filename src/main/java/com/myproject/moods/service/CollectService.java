package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.CollectionsMapper;
import com.myproject.moods.pojo.Collections;
import com.myproject.moods.pojo.CollectionsExample;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.List;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-19
 */
@Service
public class CollectService {
    @Autowired
    CollectionsMapper collectionsMapper;
    public  void insertColl(Collections collections){
        collectionsMapper.insert(collections);
    }


    public List seeColl(String username){
        CollectionsExample collectionsExample =new CollectionsExample();
        CollectionsExample.Criteria criteria =collectionsExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return collectionsMapper.selectByExample(collectionsExample);
    }

}
