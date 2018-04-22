package com.freelance.dal.Controller;

import com.freelance.dal.Entity.MyUser;
import com.freelance.dal.Entity.Project;
import com.freelance.dal.Model.AddProjectViewModel;
import com.freelance.dal.Model.BidViewModel;
import com.freelance.dal.Repository.*;
import com.freelance.dal.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/project")
@SessionAttributes("sessionUser")
public class ProjectController {

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private LanguagesRepository languagesRepository;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private BidsRepository bidsRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public ModelAndView showAddProjectView(Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("languages", languagesRepository.findAll());
        return new ModelAndView("AddProject");
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ModelAndView addProject(@ModelAttribute("addProject") AddProjectViewModel projectViewModel, BindingResult bindingResult, Model model, Principal principal){
        MyUser user = userRepository.findByUserName(principal.getName());
        projectService.saveProject(projectViewModel, user);
        return new ModelAndView("AddProject");
    }

    @RequestMapping(value = "/searchProject", method = RequestMethod.GET)
    public ModelAndView searchProject(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        Iterable<Project> Iuser = projectRepository.findAll();
        String name = "a";
        for (Project pro: Iuser) {
            if (pro.getUser() != null)
            name = pro.getUserFullName();
        }
        return new ModelAndView("SearchProject");
    }

    @RequestMapping(value = "/viewProject/{projectId}", method = RequestMethod.GET)
    public ModelAndView viewProject(@PathVariable("projectId") Long projectId, Model model){
        model.addAttribute("project", projectRepository.findById(projectId));
        model.addAttribute("bids", projectRepository.findById(projectId).getBids());
        return new ModelAndView("ViewProject");
    }

    @RequestMapping(value = "/viewProject", method = RequestMethod.POST)
    public ModelAndView bid(@RequestParam("projectId") Long projectId, @ModelAttribute("bid")BidViewModel viewModel, Model model, HttpSession session, Principal principal){
//        MyUser user = (MyUser) session.getAttribute("loggedInUser");
//        MyUser user = projectRepository.findById(projectId).getUser();
        MyUser user = userRepository.findByUserName(principal.getName());
        projectService.saveBid(viewModel, projectId, user);
        model.addAttribute("project", projectRepository.findById(projectId));
        model.addAttribute("bids", projectRepository.findById(projectId).getBids());
        return new ModelAndView("ViewProject");
    }
}
