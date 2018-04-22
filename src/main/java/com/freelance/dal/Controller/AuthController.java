package com.freelance.dal.Controller;

import com.freelance.dal.Entity.MyUser;
import com.freelance.dal.Entity.Skill;
import com.freelance.dal.Model.FreelancerFillViewModel;
import com.freelance.dal.Model.LogInViewModel;
import com.freelance.dal.Model.SignUpViewModel;
import com.freelance.dal.Repository.LanguageLevelRepository;
import com.freelance.dal.Repository.LanguagesRepository;
import com.freelance.dal.Repository.SkillRepository;
import com.freelance.dal.Repository.UserRepository;
import com.freelance.dal.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private SignUpService signUpService;
    @Autowired
    private LanguagesRepository languagesRepository;
    @Autowired
    private LanguageLevelRepository languageLevelRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/SignUp", method = RequestMethod.GET)
    public ModelAndView showSignUpForm() {
        return new ModelAndView("SignUp");
    }

    @RequestMapping(value = "/SignUp", method = RequestMethod.POST)
    private String signUp(@ModelAttribute("signUp") SignUpViewModel signUp, Model model) {
        signUpService.save(signUp);
        return "Confirm";
    }

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

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("logIn") LogInViewModel logIn, Model model, Principal principal /*HttpSession session*/){
        MyUser user = userRepository.findByEmail(principal.getName());
        if(user==null)
            user = userRepository.findByUserName(principal.getName());
        if (user != null){
//            session.setAttribute("loggedInUser", user);
            if(!user.isFilled()) {
                model.addAttribute("email", user.getEmail());
                model.addAttribute("username", user.getUserName());
                model.addAttribute("id", user.getId());
                model.addAttribute("languageLevel", languageLevelRepository.findAll());
                model.addAttribute("languages", languagesRepository.findAll());

                Iterable<Skill> writingSkills = skillRepository.findByType("Writing");
                Iterable<Skill> programmingSkills = skillRepository.findByType("Programming");
                model.addAttribute("writing", writingSkills);
                model.addAttribute("programming", programmingSkills);

                return new ModelAndView("FreelancerFill");
            }else
                return new ModelAndView("redirect:/project/searchProject");
        }else{
            model.addAttribute("massage", "Username or Password is incorrect");
            return new ModelAndView("redirect:LogIn");
        }
    }

    @RequestMapping(value = "/fillFree", method = RequestMethod.POST)
    public ModelAndView fillFree(@ModelAttribute("fillFree") FreelancerFillViewModel freefillViewModel, Model model, Principal principal /*HttpSession session*/){
        MyUser user = userRepository.findByUserName(principal.getName());
        signUpService.fillApplication(freefillViewModel, user);
        return new ModelAndView("SearchProject");
    }



























    private static String UPLOAD_FOLDER = "/home/abbos513/Documents/IdeaProjects/freelance/src/main/resources/static/userFiles/";


    @PostMapping("/upload")
    public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {

//        String fileLocation = "/home/abbos513/Desktop/";

        try {
            // read and write the file to the selected location-
            byte[] bytes = file.getBytes();
//            String extension = file.getContentType();
            Path path = Paths.get(UPLOAD_FOLDER + "1.jpg");
            Files.write(path, bytes);

//            fileLocation = path.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return new ModelAndView("FreelancerFill");
    }

}
