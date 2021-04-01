package com.cy.pj.notice.dao.impl;

import com.cy.pj.notice.dao.SysNoticeDao;
import com.cy.pj.notice.pojo.SysNotice;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //默认bean的名字为类名，然后首字母小写
public class SysNoticeDaoImpl implements SysNoticeDao {
    @Autowired
    private SqlSession sqlSession;//SqlSessionTemplate
    @Override
    public List<SysNotice> selectNotices(SysNotice notice) {
        //String statement="com.cy.pj.notice.dao.SysNoticeDao.selectNotices";
        String namespace=this.getClass().getInterfaces()[0].getName();
        //获取当前线程的方法栈，并取到当前方法的名字
        String elementId=Thread.currentThread().getStackTrace()[1].getMethodName();
        String statement=namespace+"."+elementId;
        List<SysNotice> list=sqlSession.selectList(statement, notice);
        return list;
    }

    @Override
    public int deleteById(Long... id) {
        return 0;
    }

    @Override
    public int insertNotice(SysNotice notice) {
        return 0;
    }

    @Override
    public SysNotice findById(Long id) {
        return null;
    }

    @Override
    public int updateNotice(SysNotice notice) {
        return 0;
    }
}
