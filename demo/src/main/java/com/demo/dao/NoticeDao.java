package com.demo.dao;

import com.demo.pojo.NoticePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 练习 Mapper注解 on 2021/3/8 17:57
 创建公告模块数据持久层对象
 SpringBoot基于MyBatis实现与数据库的交互时，首先要定义一个数据层接口（例如 interface NoticeDao）
 并通过mapper注解对接口进行描述，项目系统启动时，会对启动类所在包及子包中的类进行扫描，
 底层会基于接口创建其实现类（借助反射包中Proxy类进行创建），
 在实现类的内部定义基于SqlSession对象的会话过程，实现数据访问和操作，
 通过交互访问公告模块的数据 */
//Mapper注解用于描述”数据持久层接口“，由MyBatis框架定义，
@Mapper
//系统底层会基于JDK中的Proxy API为此接口产生一个实现类
public interface NoticeDao {

    /**基于条件查询公告信息
     @param noticePojo 用于封装查询参数
     @return 基于查询条件查询到结果*/
    //TODO MyBatis查询
    List<NoticePojo> selectNotice(NoticePojo noticePojo);

    /**基于id查询notice信息，
     * 说明：简单的sql映射可以直接将sql语句写到方法上面，以注解进行声明。
     @param id 查询条件，公告唯一标识id
     @return 基于id查询到结果，查询到的notice对象(存储表中的一行记录) */
    //TODO MyBatis 简单的sql查询
    @Select("SELECT * FROM sys_notices WHERE id=#{id}")
    NoticePojo findNoticeById(Long id);

    /**将内存中的noticePojo对象，持久化到数据库。持久化noticePojo对象数据
     @param noticePojo
     @return 返回写入的行数。*/
    //TODO MyBatis增加
    int insertNotice(NoticePojo noticePojo);

    /**基于多个id执行记录删除操作
     @param ids 要删除的记录id，这里的语法为可变参数(三个点为可变参数，可以看成特殊数组)
     可变参数主要是用于简化名字相同，参数类型也相同，但个数不同的这样的一系列方法的定义
     @return 删除的行数 */
    //TODO MyBatis删除
    int deleteNoticeById(Long... ids);

    /**持久化noticePojo对象数据，将内存中的noticePojo对象，更新到数据库。
     @param noticePojo 封装了要更新的数据
     @return 返回要更新的行数 */
    //TODO MyBatis改动
    int updateNotice(NoticePojo noticePojo);

}
