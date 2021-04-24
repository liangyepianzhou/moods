package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.SaysMapper;
import com.myproject.moods.pojo.Says;
import com.myproject.moods.pojo.SaysExample;
import com.myproject.moods.pojo.SaysNode;
import com.myproject.moods.pojo.Sayx;
import com.myproject.moods.recommend.TFIDFAnalyzer;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-18
 */
@Service
public class SaysService {
    final  String avatarPath ="src/main/resources/file/avatar/";
    final  String adPath ="src/main/resources/file/ad/";
    final  String photoPath ="src/main/resources/file/photo/";
    @Autowired
    SaysMapper saysMapper;
    @Autowired
    PopularPool popularPool;

    public Says insertSays(Says says){
        saysMapper.insert(says);
       return popularPool.select(says);
    }

    public List<Says> searchByName(String username){
        SaysExample example =new SaysExample();
        SaysExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo("username");
        List<Says> list=  saysMapper.selectByExample(example);
        return dealList(list);
    }

    public  List<Says> searchSome(int i){
      return   dealList(saysMapper.selectSomeThing(i)) ;
    }

    public   List dealList(List<Says> list){
        List<Sayx>list1 =new LinkedList<>();
        for (Says says:
             list) {
            Sayx sayx =new Sayx();
            String [] pictures= says.getPicture().split("//+");
            for (int i = 0; i <pictures.length ; i++) {
                pictures[i]=new File(photoPath+pictures[i]).getAbsolutePath();
            }
            sayx.setPictures(pictures);
            sayx.setAd(new File(adPath+says.getVar()).getAbsolutePath());
            sayx.setSays(says);
            list1.add(sayx);
        }
        return list1;
    }




}
