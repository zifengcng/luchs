package com.luchs.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author cheng
 * @Date 2020/9/24
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

        MessageService bean = context.getBean("messageService", MessageService.class);
        System.out.println(bean.getMessage());
    }
}
