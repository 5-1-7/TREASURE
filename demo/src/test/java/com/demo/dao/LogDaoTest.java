package com.demo.dao;

import com.demo.pojo.LogPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 练习  on 2021/3/19 8:59
 */

@SpringBootTest
public class LogDaoTest {
    @Autowired
    private LogDao logDao;

    @Test
    void insertLog() {
        LogPojo logPojo = new LogPojo();
        logPojo.setIp("0.0.0.0");
        logPojo.setStatus(1);
        logPojo.setUsername("user");
        logPojo.setTime(555L);
        logPojo.setCreatedTime(new Date());
        logDao.insertLog(logPojo);
        System.out.println("新增成功");
    }

    @Test
    void deleteLogById() {
        logDao.deleteLogById(176L, 178L);
        System.out.println("删除成功");
    }
    @Test
    void selectLogById() {
        System.out.println(logDao.findLogById(100L));
    }
    @Test
    void selectLogs() throws ParseException {
        LogPojo logPojo = new LogPojo();
        logPojo.setUsername("admin");
        logPojo.setOperation("查询");
        logPojo.setStatus(1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2020-05-01";
        logPojo.setCreatedTime(dateFormat.parse(dateString));
        List<LogPojo> listLog = logDao.selectLog(logPojo);

        /*for (LogPojo l : listLog) {
            System.out.println(l);
        }*/

        listLog.forEach((a)-> System.out.println(a));
    }
}
