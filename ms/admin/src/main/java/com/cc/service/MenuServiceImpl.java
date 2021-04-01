package com.cc.service;

import com.cc.common.pojo.Node;
import com.cc.dao.MenuDao;
import com.cc.pojo.MenuPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单业务对象
 * <p>on 2021/3/22 14:04
 */
@Transactional(readOnly = false,
        rollbackFor = Throwable.class,
        isolation = Isolation.READ_COMMITTED)
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Transactional(readOnly = true)
    @Override
    public List<MenuPojo> findAllMenu() {
        //方式1 (重点)
        return menuDao.selectAllMenu();
        /*方式2 待完善ing……查找所有菜单信息：select * from sys_menus
          在业务层对数据进行封装(一级菜单，二级菜单，三级菜单，.....),递归算法
        List<MenuPojo> menuPojoList = menuDao.selectAllMenu();
        menuPojoList.stream().filter().collect();*/
    }

    @Transactional(readOnly = true)
    @Override
    public List<Node> findMenuTreeNode() {
        return menuDao.selectMenuTreeNode();
    }

    @Transactional(readOnly = true)
    @Override
    public MenuPojo findById(Integer id) {
        MenuPojo menuPojo = menuDao.selectById(id);
        if (menuPojo == null) {
            throw new RuntimeException("没有找到对应记录");
        }
        return menuPojo;
    }

    @Override
    public int saveMenu(MenuPojo menuPojo) {
        return menuDao.insertMenu(menuPojo);
    }

    @Override
    public int updateMenu(MenuPojo menuPojo) {
        /*if (menuPojo.getId()==null) {
            return menuDao.insertMenu(menuPojo);
        }*/
        return menuDao.updateMenu(menuPojo);
    }
}
