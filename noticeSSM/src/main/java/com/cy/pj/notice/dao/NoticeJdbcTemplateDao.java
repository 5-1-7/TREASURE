package com.cy.pj.notice.dao;

import java.sql.SQLException;

public interface NoticeJdbcTemplateDao {
    void updateNotice(String sql,Object[]values) throws SQLException;
}
