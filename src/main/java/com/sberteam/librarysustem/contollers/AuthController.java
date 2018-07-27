package com.sberteam.librarysustem.contollers;


import com.sberteam.librarysustem.models.AuthenticableUsers;
import com.sberteam.librarysustem.models.BasicUsers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping(path = "/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping(path = "/index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(path = "/registration")
    public String getRegistrationPage(){ return "registration";}


    @PostMapping(path = "/registerUser")
    public String registerUser(@RequestParam("username") String username,@RequestParam String password)
    {
        System.out.println("USERNAME " + username + " " + " PASSWORD" + password);
        return "registration";
    }

    /*

    @PostMapping(path = "registerUser")
    public void registerUser(@RequestParam AuthenticableUsers user)
    {
        if(user != null)
        {
            System.out.println(user);
        }
    }*/

    @PostMapping(path = "registerReader")
    public String registerReader(@RequestParam BasicUsers user)
    {
        return "redirect:/registration";
    }
}
