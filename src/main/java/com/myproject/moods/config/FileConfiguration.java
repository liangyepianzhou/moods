package com.myproject.moods.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-19
 */
//@Configuration
public class FileConfiguration {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxRequestSize(DataSize.parse("200Mb"));
        factory.setMaxFileSize(DataSize.parse("200Mb"));
        return factory.createMultipartConfig();
    }
}
