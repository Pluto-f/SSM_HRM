package com.hrm.controller;

import com.hrm.domain.User;
import com.hrm.service.LoginService;
import com.hrm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value="/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam("loginname") String loginname,
                              @RequestParam("password") String password,
                              HttpSession session,
                              ModelAndView mv){
        // 调用业务逻辑组件判断用户是否可以登录
        User user = loginService.login(loginname, password);
//			System.out.println(user.getLoginname());
        if(user != null){
            // 将用户保存到HttpSession当中
            session.setAttribute(Constants.USER_SESSION, user);
            System.out.println("...........");
            // 客户端跳转到main页面
            mv.setViewName("redirect:/index");
        }else{
            // 设置登录失败提示信息
            System.out.println("设置登录失败提示信息");
            mv.addObject("message", "登录名或密码错误!请重新输入");
            // 服务器内部跳转到登录页面
            mv.setViewName("forward:/loginForm");
        }
        return mv;
    }
}
