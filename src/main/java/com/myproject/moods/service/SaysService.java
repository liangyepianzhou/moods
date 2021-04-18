package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.SaysMapper;
import com.myproject.moods.pojo.Says;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-18
 */
@Service
public class SaysService {

    @Autowired
    SaysMapper saysMapper;
    public  void insertSays(Says says){
        saysMapper.insert(says);
    }



}
