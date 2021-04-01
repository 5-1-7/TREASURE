package com.cy.pj.service;

import com.cy.pj.notice.pojo.SysNotice;
import com.cy.pj.notice.service.SysNoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysNoticeServiceTests {
    @Autowired
    private SysNoticeService sysNoticeService;

    @Test
    void testFindNotices(){
        SysNotice notice=new SysNotice();
        notice.setTitle("My");
        notice.setStatus("0");
        List<SysNotice> list=sysNoticeService.findNotices(notice);
        //jdk8之前
//      for(SysNotice n:list){
//            System.out.println(n);
//      }
        //JDK8 Lambda
        list.forEach(item->System.out.println(item));

    }
}
