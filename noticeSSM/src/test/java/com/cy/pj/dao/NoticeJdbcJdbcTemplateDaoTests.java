package com.cy.pj.dao;

import com.cy.pj.notice.dao.NoticeJdbcTemplateDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class NoticeJdbcJdbcTemplateDaoTests {

        @Autowired
        private NoticeJdbcTemplateDao noticeJdbcTemplateDao;
        @Test
        void insertNotice() throws SQLException {
            String sql=" insert into sys_notices (title,content,status,type,remark,createdUser) " +
                    " values (?,?,?,?,?,?)";
            Object[] notice={"html","html ....","0","1","Study","jason"};
            noticeJdbcTemplateDao.updateNotice(sql,notice);
            System.out.println("insert ok");
        }
}
