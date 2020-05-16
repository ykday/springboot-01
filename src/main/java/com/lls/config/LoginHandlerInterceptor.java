package com.lls.config;

import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lls
 * @date 2020/4/7 -10:34 AM
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser==null){
            request.setAttribute("msg","没有权限,请先登录");
            //RequestDispatcher.forward()方法将当前的request和response重定向到该 RequestDispacher指定的资源
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return  true;
        }
    }


}
