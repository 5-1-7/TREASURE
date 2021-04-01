package com.cy.pj.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @SpringBootTest 注解描述的类为spring单元测试类
 */
@SpringBootTest
public class DataSourceTest {
    /**在单元测试类中耦合数据源规范，并由spring基于@Autowired注解描述
     * 为dataSource属性注入一个具体的值*/
    @Autowired//HikariDataSource
    private javax.sql.DataSource dataSource;//请问dataSource指向的对象是谁？你怎么知道的？

    @Test
    void testGetConnection()throws SQLException {
      //System.out.println(dataSource.getClass().getName());
      //当通过dataSource获取连接时，首先会基于dataSource找到连接池(HikariPool)
      Connection conn=dataSource.getConnection();
      System.out.println(conn);
    }

}
