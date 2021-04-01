package com.cy.pj.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class JdbcTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void testSelectNotices01() throws SQLException {
        //1.获取连接
        Connection conn = dataSource.getConnection();
        //2.创建Statement
        String sql = "select id,title,content,status,type,createdTime " +
                " from sys_notices where id>=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //3.发送sql
        pstmt.setInt(1, 1);
        //ResultSet rs=pstmt.executeQuery();
        boolean flag = pstmt.execute();
        ResultSet rs = null;
        if (flag) {
            rs = pstmt.getResultSet();
            //4.处理结果
            List<Map<String, Object>> list = new ArrayList<>();
            //Map<String,Object> map=new HashMap<>();
            while (rs.next()) {//行映射，循环一次取一行，一行记录一个map对象
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getInt("id"));
                map.put("title", rs.getString("title"));
                map.put("content", rs.getString("content"));
                map.put("status", rs.getString("status"));
                map.put("type", rs.getString("type"));
                map.put("createdTime", rs.getTimestamp("createdTime"));
                //System.out.println(map);
                list.add(map);
            }
//       for(Map<String,Object> m:list){
//                System.out.println(m);
//       }
        }
    }
        @Test
        void testSelectNotices02 () throws SQLException {
            //1.获取连接
            Connection conn = dataSource.getConnection();
            //2.创建Statement
            String sql = "select id,title,content,status,type,createdTime " +
                    " from sys_notices where id>=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //3.发送sql
            pstmt.setInt(1, 1);
            //ResultSet rs=pstmt.executeQuery();
            boolean flag = pstmt.execute();
            ResultSet rs = null;
            if (flag) {
                rs = pstmt.getResultSet();
                //获取结果集对应的元数据(描述数据的数据)
                ResultSetMetaData rsmd=rs.getMetaData();
                int columnCount=rsmd.getColumnCount();
                //4.处理结果
                List<Map<String, Object>> list = new ArrayList<>();
                //Map<String,Object> map=new HashMap<>();
                while (rs.next()) {//行映射，循环一次取一行，一行记录一个map对象
                    Map<String, Object> map = new HashMap<>();
                    for(int i=1;i<=columnCount;i++){//循环一次取一个字段值
                        //获取字段别名(没起别名，默认就是字段名)
                        String columnLabel=rsmd.getColumnLabel(i);
                        map.put(columnLabel,rs.getObject(columnLabel));
                    }
                    //System.out.println(map);
                    list.add(map);
                }
                System.out.println(list);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }



    @Test
    void testInsertNotice01() throws SQLException {
        //1.获取连接(通过连接实现与数据库通道的建立)
        Connection conn=dataSource.getConnection();
        //2.创建Statement(基于此对象发送sql)
        Statement stmt=conn.createStatement();
        //3.发送sql
        String sql="insert into sys_notices (title,content,status,type,remark,createdUser,createdTime) " +
                " values ('english','English Sqlite','0','1','db2...','admin','2021-03-08 15:12:0'),('SqlServer','Study SqlServer','0','1','db2...','admin','2021-03-08 15:12:0')";
        boolean flag=stmt.execute(sql);//insert,update,delete, false;
        //4.处理结果(select,insert,update,delete)
        if(!flag) {
            int rows=stmt.getUpdateCount();
            System.out.println("update ok,rows="+rows);
        }else{
            //flag=true 表示这是一个查询操作
        }
        //5.释放资源
        stmt.close();
        conn.close();//返回池
    }

    @Test
    void testInsertNotice02() throws SQLException {
        //1.获取连接(通过连接实现与数据库通道的建立)
        Connection conn=dataSource.getConnection();
        //2.创建Statement(基于此对象发送sql)
        String sql=" insert into sys_notices (title,content,status,type,remark,createdUser) " +
                " values (?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(sql);
        //3.发送sql
        stmt.setString(1, "DataSource");
        stmt.setString(2, "Java中的数据源");
        stmt.setString(3,"0");
        stmt.setString(4, "1");
        stmt.setString(5, "Study ....");
        stmt.setString(6, "Jason");
        stmt.execute();
        System.out.println("insert ok");
        //4.处理结果(查询)
        //5.释放资源
        stmt.close();
        conn.close();//返回池
    }
}
