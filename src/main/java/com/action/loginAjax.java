package com.action;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.entity.*;
import com.service.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(allowCredentials ="true",maxAge = 3600)//跨域
public class loginAjax {
    @Autowired
    private IUserService us;

    @RequestMapping(value = "login1")
    public boolean login1(User user, HttpSession session) {
        boolean ck;
        System.out.println("进去了吗");
        User u = us.selectNandP(user);
        session.setAttribute("userinfo", u);
        System.out.println("用户信息进来：" + u);
        if (u != null) {
            ck = true;
        } else {
            ck = false;
        }
        return ck;
    }



    //注销
    @RequestMapping(value = "/cancel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int cancel(HttpSession session) {
        session.removeAttribute("userinfo");
        User user = (User) session.getAttribute("userinfo");
        if (user != null) {
            return 1;
        } else {
            System.out.println("session中用户值移除成功");
            return 0;
        }
    }

    @RequestMapping(value = "/registerName/{vuUserName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User registerName(@PathVariable(value = "vuUserName") String vuUserName) {
        User u = us.selectName(vuUserName);
        if (u != null) {
            System.out.println("确认名字：" + u);
            return u;
        } else {
            System.out.println("没有该名字");
            User u1 = new User();
            return u1;
        }
    }
}