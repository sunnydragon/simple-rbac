package com.rbac.interceptor;

import com.rbac.annotation.RequiresPermissions;
import com.rbac.common.StatusCode;
import com.rbac.exception.BusinessException;
import com.rbac.utils.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 1 认证：是否登录
 * 2 鉴权：检查方法的权限
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //OPTIONS放行
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String token = request.getHeader("token");

        if (null == token || token == "null") {
            throw new BusinessException(StatusCode.NeedLogin);
        }

        String userId = JwtUtil.getClaimFiled(token, "userId");
        String username = JwtUtil.getClaimFiled(token, "username");

        boolean verify = JwtUtil.verify(token, username, userId);
        if (!verify) {
            throw new BusinessException(StatusCode.TokenError);
        }

        /**
         * 查询 用户的 权限
         * 可以查询数据库，查询redis，也可以放入到token中直接获取
         */

        StringBuilder permsSB = new StringBuilder();
        if (StringUtils.equals("123123123", userId)) {
            permsSB.append("user:update");
        }

        HandlerMethod methodHandle = (HandlerMethod) handler;
        RequiresPermissions requiresPermissions = methodHandle.getMethodAnnotation(RequiresPermissions.class);
        if (requiresPermissions == null) {
            return true;
        }
        String[] methodPerms = requiresPermissions.value();
        String userPerms = Arrays.stream(methodPerms).collect(Collectors.joining("-"));
        if (permsSB.toString().contains(userPerms)) {
            return true;
        }

        throw new BusinessException(StatusCode.Unauthorized);


    }
}
