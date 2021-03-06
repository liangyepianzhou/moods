package com.myproject.moods.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.myproject.moods.Util.Resultbean;
import com.myproject.moods.annotation.UserLoginToken;
import com.myproject.moods.filter.SensitiveWordFilter;
import com.myproject.moods.pojo.Barrage;
import com.myproject.moods.pojo.Comments;
import com.myproject.moods.service.BarrageService;
import com.myproject.moods.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-18
 */
@Api("评论/弹幕发表")
@RestController
public class ToComment {
    @Autowired
    BarrageService barrageService;

    @Autowired
    CommentService commentService;
    @ApiOperation("弹幕发表")
    @UserLoginToken
    @PostMapping("/says/bullet")
    public Resultbean bulletSend(@ApiParam(name = "barrage",value = "弹幕内容") @RequestBody Barrage barrage
//                                      @ApiParam(name = "varPath",value = "视频文件的路径") @RequestParam("varPath") String varPath
    ){
//                String  []path =varPath.split("/");
        Set set =SensitiveWordFilter.getSensitiveWord(barrage.getContexts(),1);
        barrage.setContexts(SensitiveWordFilter.replaceSensitiveWord(barrage.getContexts(),"*",set));
        HashMap hashMap =new HashMap();
        hashMap.put("sensitiveWord",set);
        barrageService.insertBarrage(barrage);
        return  Resultbean.success(hashMap,200);
    }
    @ApiOperation("发表评论")
    @UserLoginToken
    @PostMapping("/says/comment")
    public Resultbean commentSent(@ApiParam(name = "saysId",value = "说说ID",required = true)@RequestParam("saysId") Long saysId,
                                 @ApiParam(name = "context",value = "评论内容，限长100字",required = true)@RequestParam("context") String context
                                ,HttpServletRequest httpServletRequest
                                  ){
                    String token =httpServletRequest.getHeader("token");
                    String username;
        try {
            username = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        Set set =SensitiveWordFilter.getSensitiveWord(context,1);
        context =SensitiveWordFilter.replaceSensitiveWord(context,"*",set);
        HashMap hashMap =new HashMap();
        hashMap.put("sensitiveWord",set);
        commentService.insertComment(Comments.builder().contexts(context).username(username).sayId(saysId).build());
        return Resultbean.success(hashMap,200);
    }





}
