package com.cc.service;

import com.cc.common.exception.ServiceException;
import com.cc.common.pojo.CheckBox;
import com.cc.dao.RoleDao;
import com.cc.dao.RoleMenuDao;
import com.cc.pojo.RolePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * on 2021/3/23 14:29
 */
//注解@Transactional中readOnly = false默认存在不用写
@Transactional(rollbackFor = Throwable.class,
        isolation = Isolation.READ_COMMITTED,
        timeout = 55)
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Transactional(readOnly = true)
    @Override
    public List<RolePojo> findRoles(RolePojo rolePojo) {
        return roleDao.selectRoles(rolePojo);
    }

    @Transactional(readOnly = true)
    @Override
    public RolePojo findRoleById(Integer roleId) {
        //方式1：多表关联查询
        return roleDao.selectRoleById(roleId);

        /*//方式2：单表多次查询
        RolePojo rolePojo = roleDao.selectRoleById(roleId);
        List<Integer> menuIds = roleMenuDao.selectMenuIdsByRoleId(id);
        rolePojo.setMenuIds(menuIds);
        return rolePojo;*/
    }

    @Override
    public int saveRole(RolePojo rolePojo) {
        //新增角色自身信息
        int rows = roleDao.insertRole(rolePojo);
        //新增角色菜单关系数据
        roleMenuDao.insertRoleMenus(rolePojo.getId(), rolePojo.getMenuIds());
        throw new ServiceException("== 保存失败！SAVE_ERROR ==");
        //return rows;
    }

    @Override
    public int updateRole(RolePojo rolePojo) {
        //1、更新角色自身信息
        int rows = roleDao.updateRole(rolePojo);
        if (rows == 0) {
            throw new ServiceException("记录不存在！");
        }

        //2、更新角色菜单关系数据
        //2.1、删除原有关系
        roleMenuDao.deleteByRoleId(rolePojo.getId());
        //2.2、添加新的关系
        roleMenuDao.insertRoleMenus(rolePojo.getId(), rolePojo.getMenuIds());
        return rows;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CheckBox> findCheckedRoles() {
        return roleDao.selectCheckedRoles();
    }
}
