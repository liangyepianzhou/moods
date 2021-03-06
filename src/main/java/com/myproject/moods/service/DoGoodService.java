package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.CommentsMapper;
import com.myproject.moods.dao.mapper.SaysMapper;
import com.myproject.moods.distribute.RedisDistributeLock;
import com.myproject.moods.pojo.Comments;
import com.myproject.moods.pojo.CommentsExample;
import com.myproject.moods.pojo.Says;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-21
 */
@Service
public class DoGoodService {
    @Autowired
    SaysMapper saysMapper;
    @Autowired
    PopularPool popularPool;
    @Autowired
    CommentsMapper commentsMapper;
    @Autowired
    RedisDistributeLock redisDistributeLock;
    /**
     * 为说说点赞的服务方法
     * @param says_id
     */
    public void toSaysGood(Long says_id ){
        Says says =null;

        /**
         * redis实现分布式锁，以说说id为key
         * 尚未做缓存
         */
         redisDistributeLock.getLock(String.valueOf(says_id),5000);
            says = saysMapper.selectByPrimaryKey(says_id);
            says.setGoodnums(says.getGoodnums() + 1);
            saysMapper.updateByPrimaryKeySelective(says);
            redisDistributeLock.releaseLock(String.valueOf(says_id));

        CommentsExample commentsExample =new CommentsExample();
        CommentsExample.Criteria criteria =commentsExample.createCriteria();
        criteria.andSayIdEqualTo(says.getSayId());
        List<Comments> commentsList=  commentsMapper.selectByExample(commentsExample);
        int popular =calculateFire(says.getGoodnums(),commentsList);


        popularPool.putSays(says,popular);
    }
    public void toCommentGood(Long comment_id){
        /**
         * 使用redis实现分布式锁
         * 尚需要redis实现缓存
         */
        redisDistributeLock.getLock(String.valueOf(comment_id),5000);
      Comments comments =commentsMapper.selectByPrimaryKey(comment_id);
      commentsMapper.updateByPrimaryKeySelective(comments);
      redisDistributeLock.releaseLock(String.valueOf(comment_id));
       }



    /**
     * 为弹幕点赞的方法，暂不实现
     */
    public void toBarrageGood(){};

    /**
     * 流行度计算
     * @param saysGood
     * @param commentsGood
     * @return
     */
    public int calculateFire(int saysGood,List<Comments> commentsGood){
        int sum=0;
        for (Comments comment: commentsGood
             ) {
            sum +=comment.getGoodnum();
        }

        return sum*saysGood;

    }


}
