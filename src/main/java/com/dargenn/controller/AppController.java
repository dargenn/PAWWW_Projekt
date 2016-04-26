package com.dargenn.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.dargenn.model.User;
import com.dargenn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dargenn on 4/26/16.
 */

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap modelMap){
        List<User> users = userService.findAllUsers();
        int userCount = userService.getUserCount();
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("userCount", userCount);
        return "index";
    }
}
