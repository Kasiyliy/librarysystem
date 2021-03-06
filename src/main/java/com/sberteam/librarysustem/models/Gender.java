package com.sberteam.librarysustem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Gender(String name) {
        this.name = name;
    }

    public Gender() {
    }


    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        return id.equals(gender.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
