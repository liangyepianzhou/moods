package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.SaysMapper;
import com.myproject.moods.dao.mapper.UsermMapper;
import com.myproject.moods.pojo.Userm;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-09
 */
public class FileUploadService {
    @Autowired
    UsermMapper usermMapper;
    @Autowired
    SaysMapper saysMapper;

    InputStream inputStream;

    /**
     * 将上传成功的 头像地址存入数据库
     * @param avatarUrl
     * @param username
     */
    public  void  avatarUpload(String avatarUrl,String username){
        Userm userm= Userm.builder().avatar(avatarUrl).username(username).build();
        usermMapper.updateByUsername(userm);

    }

}
