package com.zuoshao.vote.controller;

import com.zuoshao.vote.bean.User;
import com.zuoshao.vote.mapper.Usermapper;
import com.zuoshao.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:57
 */

@Controller

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userall")
    @ResponseBody
    public List<User> userall() {
        List<User> userall = userService.userall();
        return userall;
    }

    @RequestMapping(value = "/index")
    public String forindex()
    {

        return "index";
    }

    @RequestMapping(value = "/login")
    public String forlogin()
    {
        return "login";
    }
    @RequestMapping(value = "/register")
    public String forregister()
    {
        return "register";
    }

    @RequestMapping(value = "/gamesession")
    public String gamesession()
    {
        return "gamesession";
    }


    @PostMapping(value = "userlogin")
    public String userlogin(User user, HttpServletRequest request, HttpSession session){
        User userlogin = userService.userlogin(user);
        if (userlogin==null){
            request.setAttribute("message","用户名或密码不正确");
            return "login";
        }else {
            session.setAttribute("user",userlogin);
            //这里缺一个登录到后台还是前台的登录判断（根据当前用户的权限判断登录后台还是前台页面）
            return "vote";
        }
    }

    @PostMapping(value = "/userregister")
    public String userlogin(User user, HttpServletRequest request){
        Integer userregister = userService.userregister(user);
        request.setAttribute("msg","注册成功请返回登录");
        request.setAttribute("args",userregister);
        return "register";
    }

}
