package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.UsermMapper;

import com.myproject.moods.pojo.Userm;
import com.myproject.moods.pojo.UsermExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-09
 */
public class UserOptService {
    @Autowired
    UsermMapper usersMapper;

    /**
     * 查看用户名是否存在
     */
    public boolean isUsername(String username){

        Userm user =usersMapper.selectByPrimaryKey(username);
        if(user==null){return  false;}
        else {return true;}
    }

    /**
     * 查看用户手机号是否存在
     */
    public  boolean isPhone(String phone){
        UsermExample userExample =new UsermExample();
        UsermExample.Criteria criteria= userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<Userm> userms =usersMapper.selectByExample(userExample);
        if (userms.size()==0)return  false;
        else return true;
    }

    /**
     * 注册 向数据库插入用户数据
     * @param username
     * @param phone
     * @param sex Boolean值 true 为男士，false为女士
     * @param age Date类型，模糊记载用户的出生年月日
     * @param password
     */
    public  void insert(String username ,String phone,boolean sex, int age,String password ){
        Date date=new Date(System.currentTimeMillis());
        date.getTime();
        // 日期格式化类
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-mm-dd");
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,-age);
        date.setTime(calendar.getTime().getTime());
        Userm userm =Userm.builder().age(date).password(password).phone(phone).sex(sex).username(username).build();
        usersMapper.insert(userm);
    }
    /**
     * 依据手机号做查询
     * @param username
     * @return
     */
    public  Userm select(String username){
        return  usersMapper.selectByPrimaryKey(username);
    }


}
