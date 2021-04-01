package com.cc.controller;

import com.cc.common.pojo.JsonResult;
import com.cc.pojo.MenuPojo;
import com.cc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 创建 MenuController类型，通过此对象处理客户端请求，并将处理结果响应到客户端
 * 1)处理什么请求？
 * 1.1)Get
     * 1.1.1)url:/menu/
     * 1.1.2)url:/menu/{id}
 * 1.2)Post
     * 1.2.1)url:/menu/
 * 1.3)Put
     * 1.3.1)url:/menu/
 * 1.4)Delete
     * 1.4.1)url:/menu/{id}
 * 2)参数处理
     * 2.1)@PathVariable (/menu/{id})
     * 2.2)@RequestBody ({id:10,name:"",...})
     * 2.3)@RequestParam ("/?id=10&....")
 * 3)响应什么数据？
     * 3.1)JsonResult
     * 3.2)....
 * 4)异常数据如何处理？
     * 4.1)Controller方法内部 (每个方法内部都定义异常处理，try{}catch(){})
     * 4.2)Controller类的内部 (Controller类的内部定义专门的异常处理方法,@ExceptionHandler)
     * 4.3)Controller类的外部定义全局异常处理(@RestControllerAdvice,..推荐)
 * 5)控制Controller方法的调用？(HandlerInterceptor)
 * on 2021/3/22 14:31
 */
@RestController
@RequestMapping("/menu/")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单以及菜单对应的上级菜单名称
     * url: http://ip:port/menu/
     */
    @GetMapping
    public JsonResult doFindMenus() {
        return new JsonResult(menuService.findAllMenu());
    }

    /**
     * 获取菜单节点信息
     * http://ip:port/menu/treeNodes
     */
    @GetMapping("treeNodes")
    public JsonResult doFindTreeNodes() {
        return new JsonResult(menuService.findMenuTreeNode());
    }

    /**
     * 基于id查询菜单信息 (http://ip:port/menu/10)
     */
    @GetMapping("{id}")
    public JsonResult doFindMenuById(@PathVariable Integer id) {
        return new JsonResult(menuService.findById(id));
    }

    /**
     * 添加菜单信息(http://ip:port/menu)
     * @param menuPojo {name:....,url:...,sort:..,...}
     */
    @PostMapping
    public JsonResult doSaveMenu(@RequestBody MenuPojo menuPojo) {
        menuService.saveMenu(menuPojo);
        return new JsonResult("SAVE-OK,新增保存成功");
    }

    /**
     * 更新菜单信息(http://ip:port/menu)
     * @param menuPojo {id:10,name:....}
     */
    @PutMapping
    public JsonResult doUpdateMenu(@RequestBody MenuPojo menuPojo) {
        menuService.updateMenu(menuPojo);
        return new JsonResult("UPDATE-OK,更新成功");
    }
    /**
     * TODO 拓展模块：
     * 1.组织管理(部门管理)
     * 2.商品分类(一级分类，二级分类,.....)
     * 3.文章分类(小说->武侠->....)
     */
}
