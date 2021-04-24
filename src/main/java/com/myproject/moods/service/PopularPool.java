package com.myproject.moods.service;

import com.myproject.moods.pojo.Says;
import com.myproject.moods.pojo.SaysNode;
import com.myproject.moods.recommend.Keyword;
import com.myproject.moods.recommend.TFIDFAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.*;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-21
 */
@Component
public class PopularPool {
    public  int minPopular=0;
    public  int coreSize;
    public  int size;
    /**
     * 不妨设最大标签数十二个，因为刚好hashmap初始容量16，扩容因子0.75
     */
    int topInt=12;
    public  SaysNode headSaysNode ;
//    public  HashMap<Says,SaysNode> hashMap =new HashMap();
    public  HashSet<SaysNode> hashSet =new HashSet<>();


    public  int saltus= maxNumber(minPopular/100,10);
    @Autowired
    TFIDFAnalyzer tfidfAnalyzer;

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
    public  HashSet<SaysNode> getPool(){
        return hashSet;
    }

    /**
     * 添加节点
     * @param says
     * @param popularFire
     */
    private  void putNode(Says says,int popularFire){
        SaysNode saysNode=SaysNode.builder().says(says).popularFire(popularFire).build();
        /**
         * 添加标签 及TF-IDF值
         */
        HashMap map =new HashMap();
        List<Keyword> list =tfidfAnalyzer.analyze(says.getSaywords(),topInt);
        for (Keyword keyword :list
             ) {
            map.put(keyword.getName(),keyword.getTfidfvalue());
        }
        saysNode.setHashMap(map);

        hashSet.add(saysNode);
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

        Iterator iterator= hashSet.iterator();

        min =(SaysNode) iterator.next();

        /**
         * 遍历得出最小值
         * 并记录次一个的受欢迎度
         */
        if(iterator.hasNext()){
            nowNode=(SaysNode) iterator.next();
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
            /**
             * 添加标签 及TF-IDF值
             */
            HashMap map =new HashMap();
            List<Keyword> list =tfidfAnalyzer.analyze(saysNode.says.getSaywords(),topInt);
            for (Keyword keyword :list
            ) {
                map.put(keyword.getName(),keyword.getTfidfvalue());
            }
            saysNode.setHashMap(map);


//            hashMap.remove(min.says);
            hashSet.remove(min);
//            hashMap.put(saysNode.says,saysNode);
            hashSet.add(saysNode);
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

    /**
     * 在池子里找一个最相似的说说
     * @param says
     */
    public Says select(Says says){
        if(hashSet.size()==0) return says;

        SaysNode saysNode=SaysNode.builder().says(says).build();
        /**
         * 添加标签 及TF-IDF值
         */
        HashMap map =new HashMap();
        List<Keyword> list =tfidfAnalyzer.analyze(saysNode.says.getSaywords(),topInt);
        for (Keyword keyword :list
        ) {
            map.put(keyword.getName(),keyword.getTfidfvalue());
        }
        saysNode.setHashMap(map);

        Iterator iterator =hashSet.iterator();
        SaysNode first =(SaysNode)iterator.next();
        //两个说说间的相似度
        double similar =getSimilar(saysNode.hashMap,first.hashMap);
        double temp;

        for (SaysNode say :hashSet
             ) {
            temp=getSimilar(saysNode.hashMap,say.hashMap);
            if(temp>similar){
                similar=temp;
                first=say;
            }
        }

    return first.says;

    }

    /**
     * 获取两个说说间的相似度
     * @param data
     * @param inPool
     * @return
     */
    private double getSimilar(HashMap<String,Double> data,HashMap<String,Double> inPool){
        Set<String> set =data.keySet();
        double sum=0.0;
        for (String arg: set
             ) {
            if(inPool.get(arg)!=null)
            sum+=data.get(arg)*inPool.get(arg);
            else continue;
        }
        return sum;
    }






}
