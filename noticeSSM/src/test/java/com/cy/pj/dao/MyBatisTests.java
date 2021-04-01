package com.cy.pj.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
public class MyBatisTests {
    /**
     * SqlSession 是mybatis 实现与数据库会话的一个入口对象。
     * 思考？
     * 1)会话需要什么？Connection
     * 2)Connection 从哪里来？
     */
    @Autowired
    private SqlSession sqlSession;//has a
    @Test
    void testSqlSession(){
         Connection conn=sqlSession.getConnection();
         System.out.println(conn);
    }


}
