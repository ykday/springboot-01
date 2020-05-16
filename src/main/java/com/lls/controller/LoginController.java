package com.lls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * @author lls
 * @date 2020/4/7 -9:54 AM
 */

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password
                         , Model Model, HttpSession session){

        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            Model.addAttribute("msg","用户名或密码错误！");
            return "index";
        }

    }
}
