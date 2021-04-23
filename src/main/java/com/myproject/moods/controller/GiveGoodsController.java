package com.myproject.moods.controller;

import com.google.gson.internal.$Gson$Preconditions;
import com.myproject.moods.Util.Resultbean;
import com.myproject.moods.pojo.Comments;
import com.myproject.moods.pojo.Says;
import com.myproject.moods.service.DoGoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-22
 */
@Api("点赞功能接口")
@RestController
public class GiveGoodsController {
    @Autowired
    DoGoodService doGoodService;

    @ApiOperation("给说说点赞功能")
    @PostMapping("says/gooding")
    public Resultbean ToSays (@ApiParam(name ="say_id",value = "说说主键") @RequestParam(name = "say_id",required = false) Long say_id
                              ) {


        doGoodService.toSaysGood(say_id);
        return Resultbean.success(200);
    }

    @ApiOperation("给评论点赞功能")
    @PostMapping("comments/gooding")
    public Resultbean ToComments (@ApiParam(name ="comment_id",value = "说说主键") @RequestParam(name = "comment_id",required = false) Long comment_id
    ) {


        doGoodService.toCommentGood(comment_id);
        return Resultbean.success(200);
    }



}
