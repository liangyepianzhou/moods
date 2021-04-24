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
     * 用hashmap是为了在计算最相近的说说时可以最快获取到标签
     */
    public HashMap hashMap=new HashMap();
    public Says getSays() {
        return says;
    }

    public void setSays(Says says) {
        this.says = says;
    }

    public int getPopularFire() {
        return popularFire;
    }

    public void setPopularFire(int popularFire) {
        this.popularFire = popularFire;
    }

    public HashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }


}
