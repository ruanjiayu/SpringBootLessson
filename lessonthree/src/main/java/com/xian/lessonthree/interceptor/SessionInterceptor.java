package com.xian.lessonthree.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 拦截器
 * @Author: Xian
 * @CreateDate: 2019/9/6  14:09
 * @Version: 0.0.1-SHAPSHOT
 */
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //  登录不做拦截
        if (request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/loginView")) {
            log.info("我已经在拦截请求了");
            return true;
        }
        // 验证session是否存在
        Object object = request.getSession().getAttribute("session_user");
        if(object == null) {
            response.sendRedirect("/user/loginView");
            return false;
        }
        return true;
    }
}
