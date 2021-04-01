package com.cy.pj.notice.service;

import com.cy.pj.notice.pojo.SysNotice;

import java.util.List;

/**
 * 基于此接口定义公告模块业务规范，例如
 * 1)添加公告
 * 2)修改公告
 * 3)删除公告
 * 4)查询公告
 */
public interface SysNoticeService {
    /**
     * 基于条件查询公告信息
     * @param sysNotice 封装了查询条件
     * @return 查询到的公告信息
     */
    List<SysNotice> findNotices(SysNotice sysNotice);

    /**
     * 新增一条公告信息
     * @param sysNotice 封装了要新增的公告信息
     * @return 添加的行数
     */
    int saveNotice(SysNotice sysNotice);

    /**
     * 基于id查询公告信息
     * @param id 公告id
     * @return 查询到的公告信息
     */
    SysNotice findById(Long id);

    /**
     * 基于id修改公告信息
     * @param sysNotice 封装了要修改的公告信息
     * @return 更新的行数
     */
    int updateNotice(SysNotice sysNotice);

    /**
     * 基于id删除公告信息
     * @param id 公告的id
     * @return 删除的行数
     */
    int deleteById(Long...id);

}
