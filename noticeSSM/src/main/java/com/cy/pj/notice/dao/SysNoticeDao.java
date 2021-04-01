package com.cy.pj.notice.dao;

import com.cy.pj.notice.pojo.SysNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 创建公告模块数据持久层对象，借助此类型的对象基于MyBatis技术实现与数据库的交互，
 * 通过这些交互来访问或操作公告模块的数据。
 * 建议：在springboot工程中基于mybatis实现与数据库交互时，一般首先要定义一个数据层
 * 接口(例如SysNoticeDao)，然后通过@Mapper注解对接口进行描述。当系统启动时，会对启动类
 * 所在包以及子包中的类进行扫描，假如发现接口上有@Mapper注解(mybatis提供)，系统底层会基于、
 * 接口创建其实现类(借助反射包中Proxy类进行创建)，在实现类的内部，底层会又基于sqlsession
 * 对象实现数据访问和操作。
 */
@Mapper
public interface SysNoticeDao {

    /**
     * 基于条件查询公告信息
     * @param notice 用于封装查询参数
     * @return 基于查询条件查询到结果
     */
    List<SysNotice> selectNotices(SysNotice notice);

    /**
     * 基于id删除公告信息
     * @param id
     * @return 删除了几行
     * 说明：在jdk8之前，对于接口方法，假如参数有多个或者参数是数组，是不可以
     * 直接在sql映射文件中使用参数名的，需要通过@Param这个注解定义参数名，然后
     * 在sql映射语句中使用@Param注解中的名字获取参数数据。
     * int deleteById(@Param("ids")Long... id);
     * 对于数组而言在sql映射中可以直接使用array进行接收也可以。
     */
    int deleteById(Long... id);

    /**
     * 持久化notice对象数据
     * @param notice (封装了要写入的数据)
     * @return 返回写入的行数。
     */
    int insertNotice(SysNotice notice);

    /**
     * 基于id查询notice对象
     * @param id 公告唯一标识id
     * @return 基于id查询到结果
     * 建议：简单sql映射语句可以直接写到接口方法上，复杂sql还是推荐写到xml映射文件
     */
    @Select("select * from sys_notices where id=#{id}")
    SysNotice findById(Long id);

    /**
     * 持久化notice对象数据
     * @param notice (封装了要更新的数据)
     * @return 返回更新的行数。
     */
    int updateNotice(SysNotice notice);

}










