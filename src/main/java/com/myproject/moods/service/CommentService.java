package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.CommentsMapper;
import com.myproject.moods.pojo.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-19
 */
@Service
public class CommentService {
    @Autowired
    CommentsMapper commentsMapper;
    public  void insertComment(Comments comments){
        commentsMapper.insert(comments);
    }
}
