package com.fb.corebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@Configuration
@ComponentScan
public class CoreBankingMSApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoreBankingMSApplication.class, args);
  }

}
