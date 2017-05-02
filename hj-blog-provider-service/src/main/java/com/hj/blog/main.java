package com.hj.blog;/**
 * @author hongjie
 * @date 2017/4/24.15:29
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 *
 * @author
 * @create 2017-04-24 15:29
 **/
public class main {
    public static void main(String[] args) throws IOException {
        System.out.println(3);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        context.start();
        System.out.println("按任意键退出");
        System.in.read();
    }
}
