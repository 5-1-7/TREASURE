package com.notice.service;

import com.notice.pojo.NoticePojo;

import java.util.List;

/**
 * 本接口定义notice公告模块业务规范
 * 例如：添加、修改、删除、查询公告
 * 练习  on 2021/3/10 19:04
 */
public interface NoticeService {
    /**
     * 查：基于条件查询公告信息
     *
     * @param notice 封装了查询条件
     * @return 查询到的公告信息
     */
    List<NoticePojo> select(NoticePojo notice);

    /**
     * 增：新增一条公告信息
     *
     * @param notice 封装了要新增的公告信息
     * @return 添加的行数
     */
    int insert(NoticePojo notice);

    /**
     * 删：基于可能是一个或者多个id执行通告记录的删除
     *
     * @param ids 公告的id
     * @return 删除的行数
     */
    int deleteById(Long... ids);

    /**
     * 改：持久化notice对象数据
     *
     * @param notice 封装了要修改的公告信息
     * @return 更新的行数
     */
    int update(NoticePojo notice);

    /**
     * 查：基于id查询公告信息。
     * 简单sql映射语句可直接写到接口方法上，
     * 复杂sql须写到xml映射文件中。
     *
     * @param id notice公告中的唯一id
     * @return 返回基于id查询到的公告信息
     */
    NoticePojo selectById(Long id);
}
