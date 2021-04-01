package com.cc.service;

import com.cc.common.pojo.CheckBox;
import com.cc.pojo.RolePojo;

import java.util.List;

public interface RoleService {

    /**
     * 查询角色id，name信息
     * 对用户分配角色时，首先需要将角色查询出来，这个业务可以参考用户添加操作
     * @return
     */
    List<CheckBox> findCheckedRoles();

    /**
     * 基于条件查询角色相关信息
     * @param rolePojo 封装查询条件(基于用户查询，基于创建时间等)
     * @return 查询到的角色信息
     */
    List<RolePojo> findRoles(RolePojo rolePojo);

    /**
     基于id查询角色以及角色对应的菜单信息
     * 查询方案3种：<p>
     1)数据层执行多表关联查询(sys_roles left join sys_role_menus)<p>
     2)数据层执行多表嵌套查询(两个select)<p>
     3)业务发起多次单表查询<p>
     * 3.1)select * from sys_roles where id=#{id}<p>
     * 3.2)select menu_id from sys_role_menus where role_id=#{id}<p>
     * @param id
     * @return
     */
    RolePojo findRoleById(Integer id);

    /**
     * 新增角色以及角色对应的菜单关系数据<p>
     1)insert into sys_roles () values ()<p>
     2)insert into sys_role_menus () values ()<p>
     * @param rolePojo
     * @return
     */
    int saveRole(RolePojo rolePojo);

    /**
     更新角色以及角色对应的关系数据<p>
     * 1)更新角色自身信息(update sys_roles set ....)<p>
     2)更新角色和菜单关系数据<p>
     * 2.1) 删除原有关系delete from sys_role_menus where role_id=#{roleId}<p>
     * 2.2) 添加新的关系insert into sys_role_menus () values ()<p>
     * @param rolePojo
     * @return
     */
    int updateRole(RolePojo rolePojo);

}
