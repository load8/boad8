package com.org.rasp.controller.impl;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.rasp.entity.User;
import com.org.rasp.service.impl.UserService;

//×¢Èëcontroller
@Controller
@RequestMapping("/user")
public class UserController {

    //×¢Èëservice
    @Autowired
    private UserService userService;

/*    @Autowired
    private CustomerService customerService;*/

    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest request) {
        request.setAttribute("userList", userService.getAllUser());
        return "/main1";
    }

    @RequestMapping("/getUser")
    public String getUser(int userId, HttpServletRequest request) {
        request.setAttribute("user", userService.getUser(userId));
        System.out.println("edit");
        return "/editUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
    	System.out.println("hehe");
        return "/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletRequest request) {
        try {
            userService.addUser(user);
            System.out.println("savesuccess");
            return "redirect:/user/getAllUser";
        } catch (Exception e) {
        	e.printStackTrace();
            return "/error";
        }       
    }

    @RequestMapping("/delUser")
    public void delUser(int userId, HttpServletResponse response) {
        String result = "{\"result\":\"error\"}";

        if (userService.delUser(userId)) {
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {
        if (userService.updateUser(user)) {
            user = userService.getUser(user.getUserId());
            request.setAttribute("user", user);
            return "redirect:/user/getAllUser";
        } else {
            return "/error";
        }
    }
}