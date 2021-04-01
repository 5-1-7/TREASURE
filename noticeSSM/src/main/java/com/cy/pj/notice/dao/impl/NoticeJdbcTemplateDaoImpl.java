package com.cy.pj.notice.dao.impl;

import com.cy.pj.notice.dao.NoticeJdbcTemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

//@Component
@Repository
public class NoticeJdbcTemplateDaoImpl implements NoticeJdbcTemplateDao {

    private DataSource dataSource;
    /***
     * 此对象中封装了一些jdbc操作
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;//spring为其进行值注入时，还需要dataSource

//    public NoticeJdbcTemplateDaoImpl(DataSource dataSource){// @Autowired
//        this.jdbcTemplate=new JdbcTemplate(dataSource);
//    }

    @Override
    public void updateNotice(String sql, Object[] values) throws SQLException {
        jdbcTemplate.update(sql,values);
    }
}
