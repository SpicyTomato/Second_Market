package com.alliance.second_used_translation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alliance.second_used_translation")
public class SecondUsedTranslationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondUsedTranslationApplication.class, args);
    }

}
