package com.myproject.moods.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.myproject.moods.Util.Resultbean;
import com.myproject.moods.annotation.UserLoginToken;
import com.myproject.moods.pojo.Barrage;
import com.myproject.moods.pojo.Collections;
import com.myproject.moods.service.BarrageService;
import com.myproject.moods.service.CollectService;
import com.myproject.moods.service.SaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-18
 */
@Api("与查看相关接口")
@RestController
public class LookController {
        @Autowired
        SaysService saysService;
        @Autowired
        BarrageService barrageService;

        @Autowired
        CollectService collectService;
        @ApiOperation("根据用户名查看某个人的说说")
        @UserLoginToken
        @PostMapping("/says/someone")
        public Resultbean SeeSomeOneSays(@ApiParam(name = "username",value = "用户名",required = true) @RequestParam("username") String username){
                List list =saysService.searchByName(username);
                return Resultbean.success(list,200);
        }
        @ApiParam("查看最近的说说")
        @UserLoginToken
        @PostMapping("/says/something")
        public  Resultbean seeSomeSays(@ApiParam(name= "count",value = "需要的说说条数",required = true)  @RequestParam(name = "count") int count){
             List list  = saysService.searchSome(count);

             return Resultbean.success(list,200);
        }
        @ApiParam("获取弹幕")
        @UserLoginToken
        @GetMapping("/barrages")
        public Resultbean barrageGet(@ApiParam(name = "adPath",value = "视频路径",required = true) @RequestParam ("adPath") String adPath){
                String [] paths = adPath.split("/");
                String name =paths[paths.length-1];
                List list=barrageService.barrageget(name);
                return  Resultbean.success(list,200);
        }
        @ApiOperation("收藏说说")
        @UserLoginToken
        @GetMapping("says/collect")
        public Resultbean SaysColl(@ApiParam(name = "saysId",value = "说说ID",required = true)@RequestParam("saysId") Long saysId,
                                   HttpServletRequest httpServletRequest
        ){
                String token =httpServletRequest.getHeader("token");
                String username;
                try {
                        username = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                        throw new RuntimeException("401");
                }
               collectService.insertColl(Collections.builder().username(username).build());
                return Resultbean.success(200);

        }


        @ApiOperation("查看收藏")
        @UserLoginToken
        @GetMapping("collections/my")
        public  Resultbean SeeColl(HttpServletRequest httpServletRequest){
                String token =httpServletRequest.getHeader("token");
                String username;
                try {
                        username = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                        throw new RuntimeException("401");
                }
                List list=collectService.seeColl(username);
                return Resultbean.success(list,200);
        }


}
