package controller;

import Model.Appoinment;
import Model.User;
import Service.UserService;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repository.AppoinmentRepository;
import repository.MedicationRepository;

public class MainController {
    @Autowired
    private AppoinmentRepository appoinmentRepo;

    @Autowired
    private MedicationRepository medicationRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String processRegister(@ModelAttribute User user){
        userService.register(user);
        return "redirect:/login";
    }
    @GetMapping("/appointment")
    public String bookAppoinment(@ModelAttribute Appoinment appoinment){
        appoinmentRepo.save(appoinment);
        return "redirect:/appointment? sucess";
    }
    @GetMapping("/medication")
    public String medicationForm(Model model){
        model.addText("medication"
        );
        return "medication";
    }

    @PostMapping("/medication")
    //public <S> String
    //saveMedication(@ModelAttribute Medication medication){
      //   medicationRepo.save(medication);
        //return "redirect:/medication? success";
    //}

    @GetMapping("/login")
    public String loginpage(){
        return "login";
    }
}