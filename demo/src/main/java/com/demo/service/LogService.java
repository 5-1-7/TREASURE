package com.demo.service;

import com.demo.pojo.LogPojo;

import java.util.List;

/**
 * 练习  on 2021/3/18 20:15
 */
public interface LogService {

    List<LogPojo> selectLog(LogPojo logPojo);

    LogPojo findLogById(Long id);

    void insertLog(LogPojo logPojo);

    int deleteLogById(Long... ids);

}
