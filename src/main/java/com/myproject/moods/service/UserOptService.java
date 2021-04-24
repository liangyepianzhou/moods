package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.UsermMapper;

import com.myproject.moods.pojo.Userm;
import com.myproject.moods.pojo.UsermExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-09
 */
@Service
public class UserOptService {
    @Autowired
    UsermMapper usersMapper;
    final  String avatarPathMan ="src/main/resources/file/avatar/资源1.png";
    final  String avatarPathWoMan ="src/main/resources/file/avatar/资源2.png";


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
        String path;
        if(sex=true){
            path =avatarPathMan;
        }
        else {path=avatarPathWoMan;}
        Userm userm =Userm.builder().age(date).password(password).phone(phone).sex(sex).username(username).avatar(path).build();
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

    public void update(Userm userm){
        if(userm.getUsername()!=null){
            usersMapper.updateByPrimaryKeySelective(userm);
            return;
        }
        else {
            UsermExample usermExample =new UsermExample();
            UsermExample.Criteria criteria =usermExample.createCriteria();
            criteria.andPhoneEqualTo(userm.getPhone());
            usersMapper.updateByExampleSelective(userm,usermExample);
        }
    }

    public  Userm selectByTel(String tel){
        UsermExample usermExample =new UsermExample();
        UsermExample.Criteria criteria= usermExample.createCriteria();
        criteria.andPhoneEqualTo(tel);
        return usersMapper.selectByExample(usermExample).get(0);
    }

}
