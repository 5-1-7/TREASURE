package com.cc.service;

import com.cc.common.pojo.Node;
import com.cc.pojo.MenuPojo;

import java.util.List;

/**
 * 菜单业务层对象的定义
 * <p>on 2021/3/22 14:02
 */
public interface MenuService {
    /**
     * 查询所有菜单信息，包含菜单对应的上级菜单名称
     *
     * @return 查询到的菜单列表信息
     */
    List<MenuPojo> findAllMenu();

    /**
     * 查询菜单树节点信息(菜单id，菜单名称，菜单上级id)
     *
     * @return
     */
    List<Node> findMenuTreeNode();

    /**
     * 基于菜单id查询菜单信息
     *
     * @param id 菜单id
     * @return 菜单记录信息
     */
    MenuPojo findById(Integer id);

    /**
     * 新增一条菜单信息
     *
     * @param menuPojo 封装了菜单信息的对象
     * @return 表示新增的行数
     * 对象此过程我们称之为持久化，将内存中的对象保存到数据库进行持久存储。
     * ORM：对象关系映射(对象和表之间的关系映射)
     */
    int saveMenu(MenuPojo menuPojo);

    /**
     * 更新菜单信息，将用户修改的内容更新的数据库
     *
     * @param menuPojo
     * @return 更新的行数
     */
    int updateMenu(MenuPojo menuPojo);
}
