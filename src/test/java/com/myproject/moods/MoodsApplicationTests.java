package com.myproject.moods;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Calendar;

@SpringBootTest
class MoodsApplicationTests {

    @Test
    void contextLoads() {
        Date date=new Date(System.currentTimeMillis());
        date.getTime();
        int g=10;
        // 日期格式化类
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-mm-dd");
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,-g);
        date.setTime(calendar.getTime().getTime());
        System.out.println(date);
    }

}
