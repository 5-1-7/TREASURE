package com.notice.service;

import com.notice.pojo.NoticePojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 测试 NoticeService
 * on 2021/3/10 23:36
 */
@SpringBootTest
public class NoticeServiceTest {

    @Autowired
    private NoticeService noticeService;

    @Test
    void selectById(){

    }

    @Test
    void update(){

    }

    @Test
    void select() {
        NoticePojo noticePojo = new NoticePojo();
        noticePojo.setTitle("iu");
        noticePojo.setStatus("0");
        List<NoticePojo> list = noticeService.select(noticePojo);

        /*JDK8之前的遍历
        for(NoticePojo n:list){
            System.out.println(n);
        }*/

        /*JDK8使用用forEach()后在写成lambda语法，语法更简单
          是由下面匿名内部类简化成lambda
          list.forEach(new Consumer<NoticePojo>() {
            @Override
            public void accept(NoticePojo noticePojo) {
                System.out.println(noticePojo);
            }
        });
        下面的ok是自定义，ok表示其中的一个元素*/
        list.forEach(ok-> System.out.println(ok));

        //上面的lambda可替换为方法引用
        //list.forEach(System.out::println);
    }
    @Test
    void insert(){
        NoticePojo notice = new NoticePojo();
        notice.setTitle("是标题");
        notice.setContent("是内容");
        notice.setType("1");
        notice.setStatus("0");
        notice.setRemark("学习过程中");
        notice.setCreatedUser("user");
        notice.setModifiedUser("admin");
        int rows = noticeService.insert(notice);
        System.out.println(rows);
    }
}
