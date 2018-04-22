package com.freelance.dal.Service;

import com.freelance.dal.Entity.*;
import com.freelance.dal.Model.AddProjectViewModel;
import com.freelance.dal.Model.BidViewModel;
import com.freelance.dal.Repository.BidsRepository;
import com.freelance.dal.Repository.LanguagesRepository;
import com.freelance.dal.Repository.ProjectRepository;
import com.freelance.dal.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    LanguagesRepository languagesRepository;
    @Autowired
    BidsRepository bidsRepository;

    public boolean saveProject(AddProjectViewModel projectViewModel, MyUser user){

//        MyUser user = (MyUser) session.getAttribute("loggedInUser");

        List<Skill> skills = new ArrayList<Skill>();
        for (int id: projectViewModel.getSkillIds()) {
            skills.add(skillRepository.findById(id));
        }

        List<Languages> languages= new ArrayList<Languages>();

        for (int id: projectViewModel.getLanguageIds()) {
            languages.add(languagesRepository.findById(id));
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(projectViewModel.getDeadline());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Project project = new Project();
        project.setProjectTitle(projectViewModel.getProjectTitle());
        project.setAboutProject(projectViewModel.getAboutProject());
        project.setDeadline(date);
        project.setProjectBudget(projectViewModel.getProjectBudget());
        project.setSkills(skills);
        project.setLanguages(languages);
        project.setUser(user);
        projectRepository.save(project);

        return true;
    }

    public void saveBid(BidViewModel viewModel, Long projectId, MyUser user) {

        Project pro = projectRepository.findById(projectId);
        Bids bid = new Bids();
        bid.setBidText(viewModel.getText());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(viewModel.getDeadline());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bid.setOfferedPrice(viewModel.getOfferedPrice());
        bid.setOfferedDeadline(date);
        bid.setUser(user);
        bid.setProject(pro);
        bidsRepository.save(bid);
    }
}
