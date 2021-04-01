package com.cy.pj.notice.service.impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.notice.dao.SysNoticeDao;
import com.cy.pj.notice.pojo.SysNotice;
import com.cy.pj.notice.service.SysNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告业务的具体实现
 * 1)核心业务(调用数据层方法操作数据,.....)
 * 2)拓展业务(日志记录，权限控制，事务控制，缓存,....)
 */
@Service //@Component
public class SysNoticeServiceImpl implements SysNoticeService {
    //初始化日志对象(org.slf4j.*)
    private static final Logger log =
            LoggerFactory.getLogger(SysNoticeServiceImpl.class);
    //has a
    //@Autowired，假如此位置没有写这个注解，则可以通过构造方法的形式为属性赋值
    private SysNoticeDao sysNoticeDao;

    //通过构造方法直接进行DI操作
    //@Autowired 可以省略
    public SysNoticeServiceImpl(SysNoticeDao sysNoticeDao) {
        this.sysNoticeDao = sysNoticeDao;
    }

    @Override
    public List<SysNotice> findNotices(SysNotice sysNotice) {
        long t1 = System.currentTimeMillis();
        //System.out.println("method start "+t1);
        log.info("method start {}", t1);//这里的{}表示占位符
        List<SysNotice> list = sysNoticeDao.selectNotices(sysNotice);
        long t2 = System.currentTimeMillis();
        log.info("method end {}", t2);
        return list;
    }

    @Override
    public int saveNotice(SysNotice sysNotice) {
        //...
        int rows = sysNoticeDao.insertNotice(sysNotice);
        return rows;
    }

    @Override
    public SysNotice findById(Long id) {
        return sysNoticeDao.findById(id);
    }

    @Override
    public int updateNotice(SysNotice sysNotice) {
        return sysNoticeDao.updateNotice(sysNotice);
    }

    @Override
    public int deleteById(Long... id) {
        int rows = sysNoticeDao.deleteById(id);
        if (rows == 0)
            throw new ServiceException("记录可能不存在");

        return rows;
    }
}
