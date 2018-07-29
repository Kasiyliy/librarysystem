package com.sberteam.librarysustem.controllers;


import com.sberteam.librarysustem.models.AuthenticableUsers;
import com.sberteam.librarysustem.models.BasicUsers;
import com.sberteam.librarysustem.repositories.AuthenticableUsersRepository;
import com.sberteam.librarysustem.utils.CommonUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @PostMapping(path = "registerReader")
    public String registerReader(@RequestParam BasicUsers user)
    {
        return "redirect:/registration";
    }
}
