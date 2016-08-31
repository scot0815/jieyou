package com.scot.jieyou.web.interceptor;

import com.scot.jieyou.core.constant.CoreConstant;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by scot on 2016/8/3.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String LOGIN_URL = "/login.html";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        // 从session 里面获取用户名的信息
        Object obj = session.getAttribute(CoreConstant.SESSION_USER_ID);
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (obj == null || "".equals(obj.toString())) {
            response.sendRedirect(LOGIN_URL);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}