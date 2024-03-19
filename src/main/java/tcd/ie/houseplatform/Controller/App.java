package tcd.ie.houseplatform.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tcd.ie.houseplatform.Repo.UserRepo;
import tcd.ie.houseplatform.domain.User;

@Controller
public class App {

    @Autowired
    private UserRepo repo;
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){

        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        repo.save(user);

        return "register_successfully";

    }



}
