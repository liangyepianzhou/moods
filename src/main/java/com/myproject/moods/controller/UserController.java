package com.myproject.moods.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.myproject.moods.Util.CodeUtil;
import com.myproject.moods.Util.Resultbean;
import com.myproject.moods.Util.SmsTool;
import com.myproject.moods.pojo.Userm;
import com.myproject.moods.service.UserOptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-16
 */
@RestController
@Api(value = "用户登录相关接口")
public class UserController {
    int time =300000;
    @Autowired
    UserOptService userOptService;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    HashMap<String,String> hashMap =new HashMap();
    /**
     * 根据传入的参数判断是否参数（用户名/电话）存在
     * @param name
     * @param tel
     * @return map
     */
    @ApiOperation(value = "用于判断用户名或密码是否存在，可以传入一个或两个参数，？和&拼接")
    @GetMapping(value = "/is_repeat")
   public  Resultbean isExist(@ApiParam(name = "nick_name",value = "用户名") @RequestParam(name = "nick_name",required = false) String name,
                              @ApiParam(name = "tel",value = "用户电话号码") @RequestParam(name = "tel",required = false) String tel){
        Map map =new HashMap(2);
        if(name!=null)
        {
            if(userOptService.isUsername(name)){
                map.put(name,"true"); }
            else map.put(name,"false");
        }
        if(tel!=null)
        {
            if(userOptService.isPhone(tel)){
                map.put(tel,"true");
            }else map.put(tel,"false");


        }

        return Resultbean.success(map);
   }


    /**
     * 用于发送短信
     * 短信发送完，会返回一个map
     * map中有验证码的信息和系统时间
     * 前提交表单的时候讲验证码和系统时间一并返回
     * @param phone
     * @param request
     * @return
     * @throws ClientException
     */
    @ApiOperation("短信发送")
    @RequestMapping(value = "/smsXxs")
    @ResponseBody
    public Map<String,Object> smsXxs(@ApiParam(name = "phone",value = "用户电话号码，用于发送短信",required = true) @RequestParam(name = "phone")String phone,
                                     HttpServletRequest request) throws ClientException {
        Map<String,Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        String code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\""+code+"\"}";
        // 短信模板id
        String TemplateCode = "SMS_206546093";
        SendSmsResponse response = SmsTool.sendSms(phone,TemplateParam,TemplateCode);
        //将验证码code 电话号码  系统时间一并返回
        //获取当前系统的时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        //timestamp转string
        String str = df.format(time);
        map.put("verifyCode",code);
        map.put("phone",phone);
        map.put("sendtime",str);
        request.getSession().setAttribute("CodePhone",map);
        if( response.getCode().equals("OK")) {
            map.put("isOk","OK");
        }

        String sms = code+"-"+ time;
        hashMap.put(phone,sms);


        return map;
    }

    /**
     *
     * @param name
     * @param tel
     * @param psw
     * @param pin
     * @return
     */
    @ApiOperation(value = "为用户重置密码的接口方法")
    @PostMapping("/users/reset_psw")
    public Resultbean reset_psw(@ApiParam(name = "name",value = "用于进行主键查询",required = true) @RequestParam(name = "name") String name,
                                @ApiParam(name = "tel",value = "用户手机号",required = true)  @RequestParam(name = "tel")String tel,
                                @ApiParam(name = "psw",value = "新密码",required = true) @RequestParam(name = "psw") String psw,
                                @ApiParam(name = "pin",value = "用户输入的验证码",required = true)   @RequestParam(name = "pin") String pin
                                ){
        String newPsw = DigestUtils.md5Digest(psw.getBytes()).toString();
       return msgCheck(tel,pin,()->{
           Map map =new HashMap();
           Userm userm =Userm.builder().username(name).password(newPsw).build();
           userOptService.update(userm);
           map.put("msg","密码修改完成");
           return  Resultbean.success(map);
       });

    }
    @ApiOperation(value = "用户注册接口")
    @PostMapping(value = "/register")
    public Resultbean register(@ApiParam(name = "name",value = "用户昵称",required = true) @RequestParam(name = "name") String name,
                               @ApiParam(name = "tel",value = "电话号码",required = true)  @RequestParam(name = "tel") String tel,
                               @ApiParam(name = "gender",value = "性别",required = true) @RequestParam(name = "gender") Boolean gender,
                               @ApiParam(name = "psw",value = "新密码",required = true)  @RequestParam(name = "psw") String psw,
                               @ApiParam(name = "age",value = "年龄",required = true)  @RequestParam(name = "age") int age,
                               @ApiParam(name = "pin",value = "用户输入的验证码",required = true)  @RequestParam(name = "pin") String pin
                               ){
            String newPsw = DigestUtils.md5DigestAsHex(psw.getBytes()).toString();
           return msgCheck(tel,pin,()->{
               userOptService.insert(name,tel,gender,age,newPsw);
                Map map =new HashMap();
                map.put("msg","注册成功");
                return  Resultbean.success(map);
            });
    }


    /**
     * 用于检测短信验证码是否正确，是否是在五分钟内的
     * @param tel
     * @param pin
     * @param t
     * @return
     */
    public Resultbean msgCheck(String tel, String pin, Supplier t){
        Map map =new HashMap();
        String res =hashMap.get(tel);
        if(res!=null){
            String[]re =  res.split("-");
            Date date =new Date(re[1]);
            if(re[0]!=pin){
                map.put("msg","用户验证码输入错误");
                return Resultbean.success(map);
            }
            if(System.currentTimeMillis()-date.getTime()<time){
                return (Resultbean) t.get();
            }
            else
            {
                hashMap.remove(tel);
                map.put("msg","用户验证码输入超时");
                return Resultbean.success(map);
            }

        }
        else
        {
            map.put("msg","请重新发送验证码");
            return Resultbean.success(map);
        }
    }

    @ApiOperation(value = "登录接口")
    @PostMapping("users/load")
    public  Resultbean loadIn(@ApiParam(name = "tel",value = "电话号码",required = true)  @RequestParam(name = "tel")  String tel,
                              @ApiParam(name = "psw",value = "新密码",required = true)  @RequestParam(name = "psw")  String psw,
                              @ApiParam(name = "pin",value = "用户输入的验证码",required = true)  @RequestParam(name = "pin") String pin
                              ){
        Map map =new HashMap();
        if(psw!=null){
            if(userOptService.selectByTel(tel).getPassword()!=psw){
              map.put("msg","账户密码错误");
              return Resultbean.success(map);
            }
        }
        else if(pin!=null){
           return msgCheck(tel,pin,()->{
                Userm userm =userOptService.selectByTel(tel);
                String token ="";
                token = JWT.create().withAudience(userm.getUsername(),userm.getPhone()).withExpiresAt(new Date(3000,1,1)).sign(Algorithm.HMAC256(userm.getPassword()));
                map.put("token",token);
                return Resultbean.success(map);
            });
        }
        Userm userm =userOptService.selectByTel(tel);
        String token ="";
        token = JWT.create().withAudience(userm.getUsername(),userm.getPhone()).withExpiresAt(new Date(3000,1,1)).sign(Algorithm.HMAC256(userm.getPassword()));
        map.put("token",token);
        return Resultbean.success(map);
    }





}
