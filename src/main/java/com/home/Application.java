package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//https://www.hackerearth.com/problem/algorithm/little-deepu-and-array/?utm_campaign=user-activity-email&utm_medium=email&utm_source=user-recommend-problem
//https://www.hackerearth.com/problem/algorithm/bino-sum-1/?utm_campaign=user-activity-email&utm_medium=email&utm_source=user-recommend-problem

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
