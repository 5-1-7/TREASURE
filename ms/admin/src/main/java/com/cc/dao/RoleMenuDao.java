package com.cc.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * on 2021/3/23 10:35
 */
@Mapper
public interface RoleMenuDao {
    /**
     * 将角色和菜单关系数据写入到数据库
     * @param roleId
     * @param menuIds
     * @return
     */
    /*int insertRoleMenus(Integer roleId, Integer[] menuIds);
    int insertRoleMenus(Integer roleId, Integer...menuIds);*/
    int insertRoleMenus(Integer roleId, List<Integer> menuIds);

    /**
     * 当修改角色信息时，要先删除原有角色和菜单关系数据，再添加新的关系数据。
     * 基于角色id删除角色和菜单关系数据
     * @param roleId 角色id
     * @return 删除的行数
     */
    @Delete("DELETE FROM sys_role_menus WHERE role_id=#{roleId}")
    int deleteByRoleId(Integer roleId);
}
