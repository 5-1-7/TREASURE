package com.cc.controller;

import com.cc.common.pojo.JsonResult;
import com.cc.pojo.RolePojo;
import com.cc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 练习  on 2021/3/29 20:03
 */
@RestController
@RequestMapping("/role/")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public JsonResult doFindRoles(RolePojo rolePojo) {
        return new JsonResult(
                () -> roleService.findRoles(rolePojo)
        );
    }

    @GetMapping("{id}")
    public JsonResult doFindRoleById(@PathVariable Integer id) {
        return new JsonResult(roleService.findRoleById(id));
    }

    @PostMapping
    public JsonResult doSaveRole(@RequestBody RolePojo rolePojo) {
        roleService.saveRole(rolePojo);
        return new JsonResult("保存成功，S_A_V_E_O_K");
    }

    @PutMapping
    public JsonResult doUpdateRole(@RequestBody RolePojo rolePojo) {
        roleService.updateRole(rolePojo);
        return new JsonResult("更新成功，U_P_D_A_T_E_O_K");
    }

}
