package com.myproject.moods.service;

import com.myproject.moods.pojo.Says;
import com.myproject.moods.pojo.SaysNode;
import org.springframework.stereotype.Component;


import java.util.*;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-21
 */
public class PopularPool {
    public  int minPopular=0;
    public  int coreSize;
    public  int size;
    public  SaysNode headSaysNode ;
    public  HashMap<Says,SaysNode> hashMap =new HashMap();
    public  int saltus= maxNumber(minPopular/100,10);


    /**
     * 推荐池外的说说 放进推荐池中的算法
     * @param says
     * @param popularFire
     */
    public  void putSays(Says says,int popularFire){
        /**
         * 多线程并发下推荐池内的说说数量可能会超过设定的coreSize
         */
        if(size<coreSize){
            size++;
            putNode( says,popularFire);
        }
        /**
         * 轻微波动不加入推荐池
         */
        if(popularFire-minPopular<saltus){
            return;
        }
        /**
         * 发生较大波动时加入到推荐池中
         */
        if(popularFire-minPopular>saltus){
            synchronized (this){
            selectAndReplaceMin(SaysNode.builder().says(says).popularFire(popularFire).build());
            }
        }
    }
    public  HashMap getPool(){
        return hashMap;
    }

    /**
     * 添加节点
     * @param says
     * @param popularFire
     */
    private  void putNode(Says says,int popularFire){
        SaysNode saysNode=SaysNode.builder().says(says).popularFire(popularFire).build();
        hashMap.put(says,saysNode);
    }



    private  int maxNumber(int a,int b){
        if(a>b)return a;else return b;
    }

    /**
     * 找到并替换最小值
     * @param saysNode
     */
    private void selectAndReplaceMin(SaysNode saysNode){
        SaysNode min;
        SaysNode scd;
        SaysNode nowNode;
        int secMinPopular =saysNode.popularFire;
        Set keySet = hashMap.keySet();
        Iterator iterator= keySet.iterator();

        min =hashMap.get(iterator.next());

        /**
         * 遍历得出最小值
         * 并记录次一个的受欢迎度
         */
        if(iterator.hasNext()){
            nowNode=hashMap.get(iterator.next());
            if(nowNode.popularFire<min.popularFire){ //记录最小的
                min =nowNode;
                secMinPopular=min.popularFire;
            }
            else if(nowNode.popularFire<secMinPopular){
                secMinPopular =nowNode.popularFire;//记录第二小的流行度值
            }

        }

        /**
         * 如果新进入的说说热度在实际上已经超过了推荐池中的热度最小的说说
         * 则插入更新推荐池
         */
        if(min.popularFire<saysNode.popularFire){
            hashMap.remove(min.says);
            hashMap.put(saysNode.says,saysNode);
            if(saysNode.popularFire<secMinPopular){
                minPopular=saysNode.popularFire;
            }
            else
            {
                minPopular=secMinPopular;
            }
        }
        /**
         * 没有则只更新最小值
         */
        else {
            minPopular=min.popularFire;
        }
        saltus= maxNumber(minPopular/100,10);
    }








}
