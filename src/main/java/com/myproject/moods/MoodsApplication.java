package com.myproject.moods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-09
 */
@SpringBootApplication
@MapperScan("com.myproject.moods.dao.mapper")
public class MoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoodsApplication.class, args);
    }


}
