package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.BarrageMapper;
import com.myproject.moods.pojo.Barrage;
import com.myproject.moods.pojo.BarrageExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-18
 */
@Service
public class BarrageService {
    BarrageMapper barrageMapper;

    public  void insertBarrage(Barrage barrage){
        String path[] =barrage.getVar().split("/");
        barrage.setVar(path[path.length-1]);
        barrageMapper.insert(barrage);
    }

    public List<Barrage> barrageget(String var){
        BarrageExample barrageExample =new BarrageExample();
        BarrageExample.Criteria criteria = barrageExample.createCriteria();
        criteria.andVarEqualTo(var);
        return  barrageMapper.selectByExample(barrageExample);
    }


}
