package com.sberteam.librarysustem.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class BasicUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(nullable = true)
    private String patronomyc;

    private Date birthDate;

    private Long passportNumber;

    private String address;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="gender_id")
    private Gender gender;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;


    private Date createdDate = new Date();

    private Date updatedDate = new Date();

    @Column(nullable = false)
    private boolean active = true;

    public BasicUsers(){};


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicUsers basicUsers = (BasicUsers) o;

        return id.equals(basicUsers.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronomyc() {
        return patronomyc;
    }

    public void setPatronomyc(String patronomyc) {
        this.patronomyc = patronomyc;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BasicUsers(String name, String surname, String patronomyc, Date birthDate, Long passportNumber, String address, String phoneNumber, Gender gender, Set<Roles> roles, Date createdDate, Date updatedDate, boolean active) {
        this.name = name;
        this.surname = surname;
        this.patronomyc = patronomyc;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.roles = roles;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.active = active;
    }
}
