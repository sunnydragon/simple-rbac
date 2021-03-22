package com.rbac.controller;

import com.rbac.annotation.RequiresPermissions;
import com.rbac.common.ActionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/info/{userId}")
    public ActionResult getUserInfo(@PathVariable("userId") String userId) {

        log.debug("get user");
        return new ActionResult();

    }

    @GetMapping("/update/{userId}")
    @RequiresPermissions("user:update")
    public ActionResult updateUserInfo(@PathVariable("userId") String userId) {

        log.debug("update user");

        return new ActionResult();

    }

    @GetMapping("/delete/{userId}")
    @RequiresPermissions("user:delete")
    public ActionResult deleteUserInfo(@PathVariable("userId") String userId) {

        log.debug("delete user");

        return new ActionResult();

    }
}
