package com.demo.service;

import com.demo.common.exception.ServiceException;
import com.demo.dao.NoticeDao;
import com.demo.pojo.NoticePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 公告业务的具体实现：
 1)核心业务(调用数据层方法操作数据,.....)
 2)拓展业务(日志记录，权限控制，事务控制，缓存,....)
 on 2021/3/10 14:18 */

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    /*假如没有写这个注解@Autowired，则可以通过构造方法的形式为属性赋值。
      通过构造方法直接进行DI操作，@Autowired可以省略
    public NoticeServiceImpl(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }*/

    //初始化日志对象(导org.slf4j.*包)，日志语法的推荐写法！这里用了@Slf4j注解后就不用写，但要知道语法原理！
    //private static final Logger LOGGER = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Override
    public List<NoticePojo> selectNotice(NoticePojo noticePojo) {
        long t1 = System.currentTimeMillis();
        //这里的{}表示占位符
        log.info("METHOD_BEGIN: {}",t1);

        List<NoticePojo> noticePojoList = noticeDao.selectNotice(noticePojo);

        long t2 = System.currentTimeMillis();
        log.info("METHOD_END: {}",t2);

        return noticePojoList;
    }

    @Override
    public NoticePojo findNoticeById(Long id) {
        NoticePojo notice= noticeDao.findNoticeById(id);
        if (notice==null) {
            throw new ServiceException("数据不存在,DATA_DOES_NOT_EXIST");
        }
        return notice;
    }

    @Override
    public int insertNotice(NoticePojo noticePojo) {
        int rows = noticeDao.insertNotice(noticePojo);
        return rows;
    }

    @Override
    public int deleteNoticeById(Long... ids) {
        int rows = noticeDao.deleteNoticeById(ids);
        if (rows==0) {
            throw new ServiceException("数据不存在,DATA_DOES_NOT_EXIST");
        }
        return rows;
    }

    @Override
    public int updateNotice(NoticePojo noticePojo) {
        return noticeDao.updateNotice(noticePojo);
    }
}
