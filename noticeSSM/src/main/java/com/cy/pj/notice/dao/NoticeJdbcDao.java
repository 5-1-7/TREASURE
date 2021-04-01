package com.cy.pj.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface NoticeJdbcDao {
    /**
     * 数据插入
     * @param values
     * @throws SQLException
     */
    void insertNotice(String sql,Object[]values) throws SQLException;
    /**
     * 查询所有的notices信息
     * @return
     */
    List<Map<String,Object>> selectNotices(String sql,Object[]values)
            throws SQLException;
    //......

}
