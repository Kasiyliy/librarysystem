package com.sberteam.librarysustem.bootstrap;

import com.sberteam.librarysustem.models.Users;
import com.sberteam.librarysustem.repositories.UsersRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBaseTEst implements ApplicationListener<ContextRefreshedEvent> {

    UsersRepository usersRepository;

    public  DataBaseTEst(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Users user = new Users();
        user.setPatronomyc("batyaUsera");
        user.setName("user");

        usersRepository.save(user);
    }
}
