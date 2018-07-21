package com.sberteam.librarysustem.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @Column(nullable = true)
    private String patronomyc;

    private String email;

    private String password;

    private Date birthDate;

    private Long passportNumber;

    private String address;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="gender_id")
    private Gender gender;

    @ManyToMany
    private Set<Roles> roles;

    private Date createdDate;

    private Date updatedDate;

    @Column(nullable = false)
    private boolean active = true;

    public Users(){};

    public Users(String name, String surname, String patronomyc, String email, String password,
                 Date birthDate, Long passportNumber, String address,
                 String phoneNumber, Gender gender, Date createdDate,
                 Date updatedDate, boolean active)
    {
        this.name = name;
        this.surname = surname;
        this.patronomyc = patronomyc;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.active = active;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) { this.updatedDate = updatedDate; }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        return id.equals(users.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
