package com.gz.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
@Slf4j
@SpringBootApplication
public class UtilsApplication {

    public static void main(String[] args) {

        SpringApplication.run(UtilsApplication.class, args);
    }

    @Bean
    MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        factory.setLocation("D:/alpha/temp");
        log.info("[ 启动springboot ] , 设置自定义临时上传文件夹");
        return factory.createMultipartConfig();

    }

}

