package com.dargenn.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

import com.dargenn.model.Excercise;
import com.dargenn.model.User;
import com.dargenn.service.ExcerciseService;
import com.dargenn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dargenn on 4/26/16.
 */

@Controller
@RequestMapping("/**")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    ExcerciseService excerciseService;

    @Autowired
    MessageSource messageSource;

    public int currentId;;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap modelMap){

        List<User> users = userService.findAllUsers();
        int userCount = userService.getUserCount();
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("userCount", userCount);
        return "index";
    }

    @RequestMapping(value = { "/login", "/afterlogin" } )
    public String login(@ModelAttribute("login")String username,
                          @ModelAttribute("password")String password,
                          ModelMap modelMap)
    throws NoSuchAlgorithmException {

        if(userService.validateUser(username, password)) {
            modelMap.addAttribute("login", username);
            modelMap.addAttribute("password", password);
            currentId = userService.findUserByLogin(username);
            modelMap.addAttribute("currentId", currentId);

            List<Excercise> excercises = excerciseService.findUserExcercises(currentId);
            modelMap.addAttribute("excercises", excercises);

            return "afterlogin";
        } else {
            if(currentId > 0){
                modelMap.addAttribute("login", username);
                List<Excercise> excercises = excerciseService.findUserExcercises(currentId);
                modelMap.addAttribute("excercises", excercises);
                return "afterlogin";
            } else {
                return "index";
            }
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("reglogin")String username,
                                @ModelAttribute("regpassword")String password,
                                ModelMap modelMap, BindingResult result)
    throws NoSuchAlgorithmException {

        if(!userService.isUsernameUnique(username)){
            User user = new User();
            user.setLogin(username);
            user.setPassword(password);

            userService.addUser(user);

            modelMap.addAttribute("login", username);
            return "regsuccess";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/addExcercise", method = RequestMethod.GET)
    public String addExcercise(@ModelAttribute("exname")String exname,
                               @ModelAttribute("exsets")int exsets,
                               @ModelAttribute("exreps")int exreps,
                               @ModelAttribute("exweight")int exweight){

        Excercise excercise = new Excercise();
        excercise.setName(exname);
        excercise.setSets(exsets);
        excercise.setReps(exreps);
        excercise.setWeight(exweight);

        excerciseService.addExcercise(excercise, currentId);
        return "redirect:/afterlogin";
    }
}
