package com.rbac.controller;

import com.rbac.common.ActionResult;
import com.rbac.common.StatusCode;
import com.rbac.utils.JwtUtil;
import com.rbac.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Slf4j
public class AuthController {

    @PostMapping("/login")
    public ActionResult login(@Valid @RequestBody UserInfoVO userInfoVO, HttpServletResponse response) {

        log.debug("登录");
        //从数据库取出用户数据继续比较，此处进行简单比较
        if (StringUtils.equals(userInfoVO.getUsername(), "admin")
                && StringUtils.equals(userInfoVO.getPassword(), "123")) {
            String userId = "123123123";
            String token = JwtUtil.createToken(userInfoVO.getUsername(), userId);
            response.setHeader("token",token);
            return new ActionResult(token);
        }

        return new ActionResult(StatusCode.LoginFailure);
    }
}
