package com.freelance.dal.Controller;

import com.freelance.dal.Entity.Login;
import com.freelance.dal.Entity.MyUser;
import com.freelance.dal.Entity.SignUp;
import com.freelance.dal.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/")
public class SignUpController {

//    @Autowired
//    private SignUpRepository signUpRepository;
//
//    @Autowired
//    private SignUpService signUpService;

//    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public String signUp(@RequestBody SignUp signUp){
//        boolean status = this.signUpService.save(signUp);
//        if(status){
//            return "Send successfully";
//        }else
//            return "Error happened";
//    }

//    @RequestMapping(name="emailVarification", value = "/{hashCode}", method = RequestMethod.GET)
//    public String emailVarification(@PathVariable("hashCode") String hashcode){
//        if (signUpService.confirmEmail(hashcode))
//            return "Verified successfully";
//        else
//            return "Email verification failed";
//    }

//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public boolean login(@RequestBody Login login){
//        return signUpService.isUserExsist(login);
//    }

//    @RequestMapping(name = "upload", method = RequestMethod.POST)
//    public boolean fileUpload(@RequestParam("file") MultipartFile file){
//
//        String uploadFolder = "/home/abbos513/Documents/res";
//
//        if(!file.isEmpty()){
//            try {
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get(uploadFolder + file.getOriginalFilename());
//                Files.write(path, bytes);
//                return true;
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            return false;
//        }
//        return false;
//    }

}
