package com.warren.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wuzhe1159@163.com
 * @date
 * @since jdk11
 */
@SpringBootApplication(scanBasePackages = "com.warren.bootstrap.spittr")
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }
}
