package com.cy.pj.dao;

import com.cy.pj.notice.dao.NoticeJdbcDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class NoticeJdbcDaoTests {

    @Autowired
    private NoticeJdbcDao noticeJdbcDao;//has a

    @Test
    void testInsertNotice()throws SQLException{
         String sql=" insert into sys_notices (title,content,status,type,remark,createdUser) " +
                " values (?,?,?,?,?,?)";
         Object[] notice={"Spring","Spring IOC,AOP,WEB","0","1","Study","admin"};
         noticeJdbcDao.insertNotice(sql,notice);
         System.out.println("insert Ok");
    }
    @Test
    void testSelectNotices()throws SQLException {
        String sql =
                " select id,title,content,status,type,createdTime " +
                " from sys_notices where id>=?";
        List<Map<String,Object>> list=
                noticeJdbcDao.selectNotices(sql,new Object[]{1});
        for(Map<String,Object> map:list){
            System.out.println(map);
        }
    }
}
