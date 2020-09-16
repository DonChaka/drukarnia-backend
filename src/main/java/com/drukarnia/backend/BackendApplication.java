package com.drukarnia.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BackendApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }

//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(100000);
//        return multipartResolver;
//    }
}
