package com.sberteam.librarysustem.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String patronomyc;

    private String email;

    private String password;

    private Date date;

    private Long passportNumber;

    private String address;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="gender_id")
    private Gender gender;

}
