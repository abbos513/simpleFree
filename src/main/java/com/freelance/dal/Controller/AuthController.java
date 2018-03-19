package com.freelance.dal.Controller;

import com.freelance.dal.Entity.MyUser;
import com.freelance.dal.Model.LogInViewModel;
import com.freelance.dal.Model.SignUpViewModel;
import com.freelance.dal.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/SignUp", method = RequestMethod.GET)
    public ModelAndView showSignUpForm() {
        return new ModelAndView("SignUp");
    }

    @RequestMapping(value = "/SignUp", method = RequestMethod.POST)
    private String signUp(@ModelAttribute("signUp") SignUpViewModel signUp, Model model) {
        signUpService.save(signUp);
        return "Confirm";
    }

    // HTML5 + CSS + Javascript(jquery, ajax)

    @RequestMapping(name="emailVarification", value = "/hash/{hashCode}", method = RequestMethod.GET)
    public String emailVarification(@PathVariable("hashCode") String hashcode){
        if (signUpService.confirmEmail(hashcode))
            return "Confirmed";
        else
            return "SomethingWentWrong";
    }

    @RequestMapping(value = "/LogIn", method = RequestMethod.GET)
    public ModelAndView showLogInForm() {
        return new ModelAndView("LogIn");
    }

    @RequestMapping(value = "/LogIn", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("logIn") LogInViewModel logIn, Model model){
        MyUser user = signUpService.isUserExsist(logIn);
        if (user != null){
            model.addAttribute("email", user.getEmail());
            model.addAttribute("username", user.getUserName());
            return new ModelAndView("FreelancerFill");
        }else{
            model.addAttribute("massage", "Username or Password is incorrect");
            return new ModelAndView("LogIn");
        }
    }


}
