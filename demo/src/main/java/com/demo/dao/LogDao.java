package com.demo.dao;

import com.demo.pojo.LogPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 练习  on 2021/3/18 20:14
 */

@Mapper
public interface LogDao {

    List<LogPojo> selectLog(LogPojo logPojo);

    LogPojo findLogById(Long id);

    void insertLog(LogPojo logPojo);

    int deleteLogById(Long... ids);

}
