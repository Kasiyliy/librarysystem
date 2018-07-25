package com.sberteam.librarysustem.contollers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping(path = "login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping(path = "index")
    public String getIndexPage() {
        return "index";
    }

    
}
