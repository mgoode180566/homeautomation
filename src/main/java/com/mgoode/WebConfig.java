package com.mgoode;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


@EnableWebMvc
@Configuration
@ComponentScan
public class WebConfig {

    @Autowired
    ApplicationContext applicationContext;
}