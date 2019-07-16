package com.stackroute.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController
{
    @RequestMapping(value = "/")
    public String home() {
        return "login";
    }
    @Autowired
    User user;
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String user(@RequestParam("userName") String userName,@RequestParam("password") String password, Model model) {
        user.setUserName(userName);
        user.setPassword(password);
        String msg="Welcome " +user.getUserName()+ " to Stackroute";
       model.addAttribute("msg",msg);
        return "index";
    }
}

