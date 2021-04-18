package com.myproject.moods.Util;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiModel("api通用返回对象")
@Data
@Component
public  class  Resultbean {
        private int code;
        private String message;
        private Map data;
    
    public Resultbean() {
    }
    
    public static Resultbean success(List<Object> list){
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return success(map);
    }
    
    public static Resultbean success(Map<String,Object> map){
       Resultbean resultbean =new Resultbean();
        resultbean.setCode(200);
        resultbean.setMessage("success");
        resultbean.setData(map);
        return resultbean;

    }
    public static Resultbean success(){
        Resultbean resultbean =new Resultbean();
        resultbean.setCode(200);
        resultbean.setMessage("success");
        return resultbean;
    }
    public static Resultbean noFound(){
        Resultbean resultbean =new Resultbean();
        resultbean.setCode(404);
        resultbean.setMessage("success");
        return resultbean;
    }
    public static Resultbean error(int code , String msg){
        Resultbean resultbean=new Resultbean();
        resultbean.setMessage(msg);
        resultbean.setCode(code);
        return resultbean;
    }
}
