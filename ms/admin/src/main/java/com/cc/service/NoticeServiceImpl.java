package com.cc.service;

import com.cc.common.exception.ServiceException;
import com.cc.dao.NoticeDao;
import com.cc.pojo.NoticePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告业务的具体实现：
 * 1)核心业务：
 * 调用数据层方法操作数据……
 * 有可能是一个数据层方法，涉及到复杂业务时，一个业务层对象里面有可能调用多个数据层方法，
 * 以后发短信，发邮件也是在本类中实现
 * 2)拓展业务：
 * 日志记录(比如日志谁看过)、权限控制(删除是有权限吗)、
 * 事务控制（insert update）、为了提高性能加缓存…… <p>
 * 注解 @Service 描述的对象表示是spring容器中的一个bean对象
 * <p>练习 on 2021/3/10 19:11
 */
@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {
    /*初始化日志对象(导 org.slf4j.* 包，)，
      等号左边Logger对外提供一个接口，等号右边是具体实现
      在哪个类里写日志，LoggerFactory.getLogger的参数就是 类名.class
    private static final Logger log =
            LoggerFactory.getLogger(NoticeServiceImpl.class);
      当类被@Slf4j注解时，此处就不需要写创建日志对象*/

    /*假如此位置没有写@Autowired这个注解，
      则可以通过构造方法的形式为属性赋值*/
    @Autowired
    private NoticeDao noticeDao;

    /*如果通过构造方法直接进行DI操作，@Autowired 这里可省略
    public NoticeServiceImpl(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }*/

    @Override
    public List<NoticePojo> findNotice(NoticePojo notice) {

        long t1 = System.currentTimeMillis();
        /*info是日志级别：trace < debug < info < error
          这里的{}表示占位符，后面的逗号值会传入{}，多个参数可逗号隔开
          log.info("Method Begin {} {}",t1,100)*/
        log.info("方法开始时间{}", t1);

        List<NoticePojo> result = noticeDao.select(notice);

        long t2 = System.currentTimeMillis();
        log.info("方法结束时间{}", t2);

        return result;
    }

    @Override
    public NoticePojo findNoticeById(Long id) {
        NoticePojo notice = noticeDao.selectById(id);
        if (notice==null) {
            throw new ServiceException("记录可能不存在哦");
        }
        return notice;
    }

    @Override
    public int insert(NoticePojo notice) {
        int rows = noticeDao.insert(notice);
        return rows;
    }

    @Override
    public int deleteById(Long... ids) {
        int rows = noticeDao.deleteById(ids);
        if (rows == 0) {
            throw new ServiceException("记录可能不存在噢");
        }
        return rows;
    }

    @Override
    public int update(NoticePojo notice) {
        return noticeDao.update(notice);
    }


}
