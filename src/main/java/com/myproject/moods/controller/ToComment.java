package com.myproject.moods.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.myproject.moods.Util.Resultbean;
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
    @PostMapping("/says/bullet")
    public Resultbean bulletSend(@ApiParam(name = "barrage",value = "弹幕内容") @RequestBody Barrage barrage
//                                      @ApiParam(name = "varPath",value = "视频文件的路径") @RequestParam("varPath") String varPath
    ){
//                String  []path =varPath.split("/");
        barrageService.insertBarrage(barrage);
        return  Resultbean.success();
    }
    @ApiOperation("发表评论")
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
        commentService.insertComment(Comments.builder().contexts(context).username(username).sayId(saysId).build());
        return Resultbean.success();
    }





}
