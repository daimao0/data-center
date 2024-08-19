package com.dm.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author daimao
 * @date 2024/8/18 2:32
 */
@ComponentScan(basePackages = {"com.dm"})
@SpringBootApplication
public class DataCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataCenterApplication.class,args);
    }
}
