package com.myproject.moods;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.myproject.moods.dao.mapper.SaysMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class MoodsApplicationTests {
//   @Autowired
//    SaysMapper saysMapper;

    @Test
    void c(){

//        String content="孩子上了幼儿园 安全防拐教育要做好";
//        int topN=5;
//        TFIDFAnalyzer tfidfAnalyzer=new TFIDFAnalyzer();
//        List<Keyword> list=tfidfAnalyzer.analyze(content,topN);
//        for(Keyword word:list)
//            System.out.println(word.getName()+":"+word.getTfidfvalue()+",");
        // 防拐:0.1992,幼儿园:0.1434,做好:0.1065,教育:0.0946,安全:0.0924

        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
        }



    }




//    @Test
//    void contextLoads() {
////        Date date=new Date(System.currentTimeMillis());
////        date.getTime();
////        int g=10;
////        // 日期格式化类
//////        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-mm-dd");
////        Calendar calendar =Calendar.getInstance();
////        calendar.setTime(date);
////        calendar.add(Calendar.YEAR,-g);
////        date.setTime(calendar.getTime().getTime());
////        System.out.println(date);
////
////        int a =1;
//////        List list =saysMapper.selectSomeThing(a);
////          Iterator iterator =   list.iterator();
////            while (iterator.hasNext()){
////                System.out.println(iterator.next());
////            }
//
//    java.util.Date date= new Date("4");
//        System.out.println(date);
//
//    }

}
