package com.cy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 注解描述的类为springboot 工程启动运行的一个入口。
 *
 * FAQ?
 * 1.这个启动类在启动时都会做什么呢？
 * 1)将磁盘中的类读到内存?(位置，技术)
 * 2)对内存中类进行配置信息提取，构建对象，存储对象
 * 3)读取配置信息对系统进行初始化配置
 *
 * 2.如何知道哪些类被加载到内存了？
 * 通过JVM参数(-XX:+TraceClassLoading)的配置，对类的加载过程进行呈现
 *
 * 3.一个类文件读到内存以后会做什么？基于类的字节码信息创建字节码对象(Class)
 */
//@MapperScan("com.cy.pj.notice.dao")
@SpringBootApplication
public class NoticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }
}
