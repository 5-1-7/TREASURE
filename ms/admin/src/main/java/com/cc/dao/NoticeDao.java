package com.cc.dao;

import com.cc.pojo.NoticePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 创建公告模块数据持久层对象，借助此类型的对象基于MyBatis技术实现与数据库的交互。
 * Mapper注解用于描述”数据持久层接口“，由MyBatis框架定义。
 *  在SpringBoot工程基于MyBatis实现与数据库交互时，
 *  首先要定义一个数据层接口(例如 interface NoticeDao)
 *  然后通过@mapper注解对接口进行描述，当系统启动时，
 *  会对启动类所在包及子包中的类进行扫描，假如发现接口上有@Mapper注解，
 *  系统底层会基于JDK中的Proxy API为此接口创建其实现类(借助反射包中Proxy类进行创建)，
 *  在实现类的内部，底层会又基于SqlSession对象实现数据访问和操作。
 *
 * 练习 @Mapper注解 Notice DAO
 * on 2021/3/10 19:04 */
@Mapper
public interface NoticeDao {

    /**
     * 查：基于id查询公告信息。
     * @param id 查询条件，notice公告中的唯一id
     * @return 基于id查询到的公告信息
     * 查询到的notice对象(存储表中的一行记录)<p>
     * 建议：简单sql映射语句可以直接写到接口方法上
     * 复杂sql还是推荐写到xml映射文件
     */
    @Select("SELECT * FROM sys_notices WHERE id=#{id}")
    NoticePojo selectById(Long id);
    /**
     * 查：基于条件查询公告信息
     * @param notice 封装了查询条件(参数)
     * @return 基于查询条件查询到结果
     */
    List<NoticePojo> select(NoticePojo notice);

    /**
     * 增：新增一条公告信息。
     * 持久化notice对象数据，将内存中的notice对象，持久化到数据库。
     * @param notice 封装了要新增的公告信息(封装了要写入的数据)
     * @return 添加的行数(返回写入的行数)
     */
    int insert(NoticePojo notice);

    /**
     * 删：基于可能是一个或者多个id执行通告记录的删除
     * 这里的语法为可变参数(三个点为可变参数，可以看成特殊数组)
     * 可变参数主要是用于简化名字相同，参数类型也相同，但个数不同的这样的一系列方法的定义
     * @param ids 公告的id
     * @return 删除的行数(删除了几行) <p>
     * 说明：在jdk8之前，对于接口方法，假如参数有多个或者参数是数组，
     * 是不可以直接在sql映射文件中使用参数名的，需要通过@Param这个注解定义参数名，
     * 然后在sql映射语句中使用@Param注解中的名字获取参数数据。
     * int deleteById(@Param("ids")Long... id);
     * 对于数组而言在sql映射中可以直接使用array进行接收也可以。
     */
    int deleteById(Long... ids);

    /**
     * 改：持久化notice对象数据
     * @param notice 封装了要修改的公告信息(要更新的数据)
     * @return 返回更新的行数
     */
    int update(NoticePojo notice);
}
