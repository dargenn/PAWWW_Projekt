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

import com.dargenn.model.*;
import com.dargenn.service.*;
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
    MealService mealService;

    @Autowired
    SuplementService suplementService;

    @Autowired
    UserClipboardService userClipboardService;

    @Autowired
    UserQuotesService userQuotesService;

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

            List<Meal> meals = mealService.findUserMeals(currentId);
            modelMap.addAttribute("meals", meals);

            List<Suplements> suplements = suplementService.findUserSuplements(currentId);
            modelMap.addAttribute("suplements", suplements);

            List<UserClipboard> userClipboards = userClipboardService.findUserUserClipboards(currentId);
            modelMap.addAttribute("userClipboards", userClipboards);

            List<UserQuotes> userQuotes = userQuotesService.findUserUserQuotes(currentId);
            modelMap.addAttribute("userQuotes", userQuotes);

            return "afterlogin";
        } else {
            if(currentId > 0){
                modelMap.addAttribute("login", username);

                List<Excercise> excercises = excerciseService.findUserExcercises(currentId);
                modelMap.addAttribute("excercises", excercises);

                List<Meal> meals = mealService.findUserMeals(currentId);
                modelMap.addAttribute("meals", meals);

                List<Suplements> suplements = suplementService.findUserSuplements(currentId);
                modelMap.addAttribute("suplements", suplements);

                List<UserClipboard> userClipboards = userClipboardService.findUserUserClipboards(currentId);
                modelMap.addAttribute("userClipboards", userClipboards);

                List<UserQuotes> userQuotes = userQuotesService.findUserUserQuotes(currentId);
                modelMap.addAttribute("userQuotes", userQuotes);

                return "afterlogin";
            } else {
                return "errorlogin";
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
            return "errorreg";
        }
    }

    /*
    EXCERCISE
     */
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

    @RequestMapping(value = "/delete-{id}-excercise")
    public String deleteExcercise(@PathVariable int id){
        excerciseService.deleteExcercise(id);
        return "redirect:/afterlogin";
    }

    /*
    MEAL
     */
    @RequestMapping(value = "/addMeal", method = RequestMethod.GET)
    public String addMeal(@ModelAttribute("mmeal")String mmeal,
                          @ModelAttribute("mamount")String mamount,
                          @ModelAttribute("mtype")String mtype){

        Meal meal = new Meal();
        meal.setName(mmeal);
        meal.setAmount(mamount);
        meal.setType(mtype);

        mealService.addMeal(meal, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-meal")
    public String deleteMeal(@PathVariable int id){
        mealService.deleteMeal(id);
        return "redirect:/afterlogin";
    }

    /*
    SUPLEMENT
     */
    @RequestMapping(value = "/addSuplement", method = RequestMethod.GET)
    public String addSuplement(@ModelAttribute("sname")String sname,
                          @ModelAttribute("samount")String samount){
        Suplements suplement = new Suplements();
        suplement.setName(sname);
        suplement.setAmount(samount);

        suplementService.addSuplement(suplement, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-suplement")
    public String deleteSuplement(@PathVariable int id){
        suplementService.deleteSuplement(id);
        return "redirect:/afterlogin";
    }

    /*
   USER CLIPBOARD
    */
    @RequestMapping(value = "/addUserClipboard", method = RequestMethod.GET)
    public String addUserClipboard(@ModelAttribute("ccontent")String content){
        UserClipboard userClipboard = new UserClipboard();
        userClipboard.setContent(content);

        userClipboardService.addUserClipboard(userClipboard, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-clipboard")
    public String deleteUserClipboard(@PathVariable int id){
        userClipboardService.deleteUserClipboard(id);
        return "redirect:/afterlogin";
    }

    /*
   USER QUOTES
   */
    @RequestMapping(value = "/addQuote", method = RequestMethod.GET)
    public String addQuote(@ModelAttribute("qcontent")String content){
        UserQuotes userQuotes = new UserQuotes();
        userQuotes.setContent(content);

        userQuotesService.addUserQuotes(userQuotes, currentId);
        return "redirect:/afterlogin";
    }

    @RequestMapping(value = "/delete-{id}-quote")
    public String deleteQuote(@PathVariable int id){
        userQuotesService.deleteUserQuotes(id);
        return "redirect:/afterlogin";
    }
}
