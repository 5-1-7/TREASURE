package com.cy.pj.notice.dao.impl;

import com.cy.pj.notice.dao.NoticeJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository//此注解一般用于描述数据访问对象的具体实现类
public class NoticeJdbcDaoImpl implements NoticeJdbcDao {
    @Autowired
    private DataSource dataSource;

    @Override
    public void insertNotice(String sql,Object[]values)throws SQLException {
        //1.获取连接(通过连接实现与数据库通道的建立)
        Connection conn=dataSource.getConnection();
        //2.创建Statement(基于此对象发送sql)
        PreparedStatement stmt=conn.prepareStatement(sql);
        //3.发送sql
        for(int i=0;i<values.length;i++){
            stmt.setObject(i+1,values[i]);
        }
        stmt.execute();
        //4.处理结果(查询)
        //5.释放资源
        stmt.close();
        conn.close();//返回池
    }

    @Override
    public List<Map<String, Object>> selectNotices(String sql,Object[] values) throws SQLException {
        //1.获取连接
        Connection conn = dataSource.getConnection();
        //2.创建Statement
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //3.发送sql
        for(int i=0;i<values.length;i++){
            pstmt.setObject(i+1, values[i]);
        }
        //ResultSet rs=pstmt.executeQuery();
        boolean flag = pstmt.execute();
        //4.处理结果
        ResultSet rs = null;
        List<Map<String, Object>> list = new ArrayList<>();
        if (flag) {
            rs = pstmt.getResultSet();
            //获取结果集对应的元数据(描述数据的数据)
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnCount=rsmd.getColumnCount();
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
        }
        rs.close();
        pstmt.close();
        conn.close();
        return list;
    }
}
