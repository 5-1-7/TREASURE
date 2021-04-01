package com.cc.dao;

import com.cc.common.pojo.CheckBox;
import com.cc.pojo.RolePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 创建角色数据逻辑访问对象，基于此对象访问数据库中角色相关数据
 * <p>on 2021/3/23 10:27
 */
@Mapper
public interface RoleDao {

    /**
     * 基于条件查询角色信息
     *
     * @param rolePojo 封装了查询条件的对象
     * @return 查询到的角色列表信息结果
     */
    List<RolePojo> selectRoles(RolePojo rolePojo);

    /**
     * 基于 id 查找对应的角色
     *
     * @param id 角色 id
     * @return 查找到具体角色对象
     */
    RolePojo selectRoleById(Integer id);

    /**
     * 向表中新增一条角色信息（对象持久化）
     *
     * @param rolePojo 封装了要新增的角色信息的对象
     * @return 新增的行数
     */
    int insertRole(RolePojo rolePojo);

    /**
     * 基于角色 id 更新角色信息
     *
     * @param rolePojo 封装了要新增的角色信息的对象
     * @return 更新的行数
     */
    int updateRole(RolePojo rolePojo);

    /**
     * 查询角色id,名字然后一行记录封装为CheckBox对象，后续会将查询到的数据应用到用户模块
     * @return
     */
    @Select("SELECT id,name FROM sys_roles")
    List<CheckBox> selectCheckedRoles();

}
