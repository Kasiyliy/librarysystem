package com.sberteam.librarysustem.controllers;


import com.sberteam.librarysustem.models.AuthenticableUsers;
import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.repositories.AuthenticableUsersRepository;
import com.sberteam.librarysustem.utils.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    AuthenticableUsersRepository authenticableUsersRepository;

    public AuthController(AuthenticableUsersRepository authenticableUsersRepository) {
        this.authenticableUsersRepository = authenticableUsersRepository;
    }

    @GetMapping(path = "/login")
    public String getLoginPage(){
        return "auth/login";
    }

    @GetMapping(path = "/registration")
    public String getRegistrationPage(){ return "auth/registration";}


    @PostMapping(path = "/registration")
    public String registerUser(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("repassword") String repassword)
    {
        if(password.equals(repassword)){
            AuthenticableUsers user = new AuthenticableUsers();
            user.setUsername(username);
            user.setPassword(CommonUtils.encode(password));
            authenticableUsersRepository.save(user);
            return "auth/login";
        }else{
            return "auth/registration";
        }
    }

    @PostMapping(path = "registerReader")
    public String registerReader(@RequestParam BasicUsers user)
    {
        return "redirect:/registration";
    }
}
