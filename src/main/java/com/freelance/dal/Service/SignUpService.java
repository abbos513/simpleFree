package com.freelance.dal.Service;

import com.freelance.dal.Entity.*;
import com.freelance.dal.Model.FreelancerFillViewModel;
import com.freelance.dal.Model.LogInViewModel;
import com.freelance.dal.Model.SignUpViewModel;
import com.freelance.dal.Repository.*;
import com.freelance.dal.Utils.MailService;
import com.freelance.dal.Utils.RandonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class SignUpService {

    RandonString randonString = new RandonString();
    private SignUpRepository signUpRepository;
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private LanguageLevelRepository languageLevelRepository;
    @Autowired
    private LanguagesRepository languagesRepository;

    @Autowired
    public SignUpService(SignUpRepository signUpRepository, UserRepository userRepository){
        this.signUpRepository = signUpRepository;
        this.userRepository = userRepository;
    }

    public boolean save(SignUpViewModel signUpViewModel){
        SignUp signUp = new SignUp(signUpViewModel.getEmail(), signUpViewModel.getUsername(), signUpViewModel.getPassword(), signUpViewModel.getUserType());
        String varificationString = randonString.randonString();
        signUp.setHashCode(varificationString);
        boolean isMailSent=false;
        try{
            this.mailService.sendEmail(signUp);
            isMailSent = true;
        }catch (MailException e){
            isMailSent =false;
        } catch (MessagingException e) {
            e.printStackTrace();
            isMailSent = false;
        }

        if(isMailSent) {
            this.signUpRepository.save(signUp);
            return true;
        }else{
            return false;
        }
    }

    public boolean confirmEmail(String hashCode){
        SignUp signUp = this.signUpRepository.findAllByHashCode(hashCode);
        MyUser newUser = new MyUser();
        if(signUp!=null) {
            newUser.setEmail(signUp.getEmail());
            newUser.setUserName(signUp.getUsername());
            newUser.setPassword(signUp.getPassword());
            newUser.setFilled(false);
            this.userRepository.save(newUser);
            return true;
        }else {
            return false;
        }
    }

    public MyUser isUserExsist(LogInViewModel login) {

        MyUser user = this.userRepository.findByEmailAndPassword(login.getEmailOrUsername(), login.getPassword());

        if(user == null)
            user = this.userRepository.findByUserNameAndPassword(login.getEmailOrUsername(), login.getPassword());
//        if(user != null) {
//            return user;
//        }else{
//            return false;
//        }
        return user;
    }

    public boolean fillApplication (FreelancerFillViewModel freelancerFillViewModel, MyUser user){

//        MyUser user = (MyUser) session.getAttribute("loggedInUser");
        MyUser newUser = this.userRepository.findByEmail(user.getEmail());

//        int[] arr = (int[])freelancerFillViewModel.getSkillId();

        List<Skill> skillList= new ArrayList<Skill>();

        for (int id: freelancerFillViewModel.getSkillId()) {
            skillList.add(skillRepository.findById(id));
        }

//        List<UserLanguageLevel> userLanguageLevels= new ArrayList<UserLanguageLevel>();
//
//        for(int id: freelancerFillViewModel.getLanguageId()){
//            UserLanguageLevel userLanguageLevel = new UserLanguageLevel();
//            userLanguageLevel.setLanguage(languagesRepository.findAllById(id));
//            userLanguageLevel.setLevel(languageLevelRepository.findAllById(id));
//            userLanguageLevel.setUser(newUser);
//            userLanguageLevels.add(userLanguageLevel);
//        }

        newUser.setFirstName(freelancerFillViewModel.getFirstName());
        newUser.setLastName(freelancerFillViewModel.getLastName());
        newUser.setPhoneNumber(freelancerFillViewModel.getPhoneNumber());

        newUser.setCity(freelancerFillViewModel.getCity());
        newUser.setRegionState(freelancerFillViewModel.getRegionState());
        newUser.setCountry(freelancerFillViewModel.getCountry());
        newUser.setAboutText(freelancerFillViewModel.getAboutMe());
        newUser.setFilled(true);

        newUser.setSkills(skillList);
//        newUser.setLanguages(userLanguageLevels);
        this.userRepository.save(newUser);
        return true;
    }
}