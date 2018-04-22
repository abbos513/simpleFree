package com.freelance.dal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "")
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showSignUpForm() {
        return new ModelAndView("redirect:/auth/LogIn");
    }

}
