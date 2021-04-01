package com.demo.service;

import com.demo.common.exception.ServiceException;
import com.demo.dao.LogDao;
import com.demo.pojo.LogPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 练习  on 2021/3/18 20:15
 */

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    /*在这里直接通过构造方法为属性赋值就可以不用@Autowired
    public LogServiceImpl(LogDao logDao) {
        this.logDao = logDao;
    }*/
    @Override
    public List<LogPojo> selectLog(LogPojo logPojo) {
        List<LogPojo> logPojoList = logDao.selectLog(logPojo);
        return logPojoList;
    }

    @Override
    public LogPojo findLogById(Long id) {
        LogPojo logPojo = logDao.findLogById(id);
        if (logPojo==null) {
            throw new ServiceException("数据不存在,DATA_DOES_NOT_EXIST");
        }
        return logPojo;
    }

    @Override
    public void insertLog(LogPojo logPojo) {
        logDao.insertLog(logPojo);
    }

    @Override
    public int deleteLogById(Long... ids) {
        int result = logDao.deleteLogById(ids);
        if (result==0) {
            throw new ServiceException("数据不存在,DATA_DOES_NOT_EXIST");
        }
        return result;
    }
    
}
