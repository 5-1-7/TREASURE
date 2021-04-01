package com.cy.pj.dao;

import com.cy.pj.notice.dao.SysNoticeDao;
import com.cy.pj.notice.pojo.SysNotice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysNoticeDaoTests {

    @Autowired
    //@Qualifier("sysNoticeDaoImpl")
    private SysNoticeDao sysNoticeDao;

    @Test
    void testSelectNotices(){
         SysNotice notice=new SysNotice();
         notice.setTitle("my");
         //notice.setType("1");
         //notice.setModifiedUser("admin");
         List<SysNotice> list= sysNoticeDao.selectNotices(notice);
         for(SysNotice n:list){
             System.out.println(n);
         }
    }
    @Test
    void testInsertNotice(){
        SysNotice notice=new SysNotice();
        notice.setTitle("项目峰会");
        notice.setContent("晚上8八点开讲");
        notice.setType("1");
        notice.setStatus("0");
        notice.setRemark("学习过程中");
        notice.setCreatedUser("tony");
        notice.setModifiedUser("tony");
        int rows=sysNoticeDao.insertNotice(notice);
        System.out.println("insert ok,rows="+rows);
    }

    @Test
    void testDeleteById(){
       int rows= sysNoticeDao.deleteById(100L,200L);
        System.out.println("delete rows="+rows);
    }

    @Test
    void testFindById(){
        SysNotice notice=sysNoticeDao.findById(1L);
        System.out.println(notice);
    }

    @Test
    void testUpdateNotice(){
        SysNotice notice=sysNoticeDao.findById(7L);
        notice.setContent("晚上9点开讲");
        notice.setModifiedUser("张久军老师");
        sysNoticeDao.updateNotice(notice);
    }



}
