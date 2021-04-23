package com.myproject.moods.pojo;

import lombok.Builder;

import java.util.HashMap;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-21
 */
@Builder
public class SaysNode {
    public  Says says;
    public int popularFire;
    /**
     * 不妨设最大标签数十二个，因为刚好hashmap初始容量16，扩容因子0.75
     */
    public HashMap hashMap=new HashMap();
}
