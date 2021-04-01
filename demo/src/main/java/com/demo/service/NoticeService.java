package com.demo.service;

import com.demo.pojo.NoticePojo;

import java.util.List;

/**基于此接口定义公告模块业务规范，例如：
 1)添加公告 2)修改公告 3)删除公告 4)查询公告
 练习 interface Service on 2021/3/10 14:08
 */

public interface NoticeService {
    /**
     * 基于条件查询公告信息
     * @param noticePojo 封装了查询条件
     * @return 查询到的公告信息
     */
    List<NoticePojo> selectNotice(NoticePojo noticePojo);

    /**
     * 基于id查询公告信息
     * @param id 公告id
     * @return 查询到的公告信息
     */
    NoticePojo findNoticeById(Long id);

    /**
     * 新增一条公告信息
     * @param noticePojo 封装了要新增的公告信息
     * @return 添加的行数
     */
    int insertNotice(NoticePojo noticePojo);

    /**
     * 基于id删除公告信息
     * @param ids 公告的id
     * @return 删除的行数
     */
    int deleteNoticeById(Long... ids);

    /**
     * 基于id修改公告信息
     * @param noticePojo 封装了要修改的公告信息
     * @return 更新的行数
     */
    int updateNotice(NoticePojo noticePojo);
}
