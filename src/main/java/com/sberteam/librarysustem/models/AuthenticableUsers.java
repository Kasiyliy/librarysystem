package com.sberteam.librarysustem.models;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
public class AuthenticableUsers extends BasicUsers {

    private String username;
    private String password;

    public AuthenticableUsers() {
    }

    public AuthenticableUsers(String name, String surname, String patronomyc, Date birthDate, Long passportNumber, String address, String phoneNumber, Gender gender, Set<Roles> roles, Date createdDate, Date updatedDate, boolean active, String username, String password) {
        super(name, surname, patronomyc, birthDate, passportNumber, address, phoneNumber, gender, roles, createdDate, updatedDate, active);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return  "AuthenticableUsers{" +super.toString()+
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
