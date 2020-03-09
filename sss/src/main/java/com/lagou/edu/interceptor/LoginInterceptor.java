package com.lagou.edu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义springmvc拦截器
 */
public class LoginInterceptor  implements HandlerInterceptor {
    /**
     * 会在handler方法业务逻辑执行之前执行
     * 往往在这里完成权限校验工作
     * @param request
     * @param response
     * @param handler
     * @return  返回值boolean代表是否放行，true代表放行，false代表中止
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyIntercepter01 preHandle......");
        HttpSession session = request.getSession();
        Object uid = session.getAttribute("uid");

        if (uid != null) {
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/user/login");
        return false;
    }
}
