package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.SaysMapper;
import com.myproject.moods.pojo.Says;
import com.myproject.moods.pojo.SaysExample;
import com.myproject.moods.pojo.Sayx;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public  void insertSays(Says says){
        saysMapper.insert(says);
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
                pictures[i]=photoPath+pictures[i];
            }
            sayx.setPictures(pictures);
            sayx.setAd(adPath+says.getVar());
            sayx.setSays(says);
            list1.add(sayx);
        }
        return list1;
    }
}
