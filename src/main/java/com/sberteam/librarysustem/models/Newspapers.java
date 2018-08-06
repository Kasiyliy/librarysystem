package com.sberteam.librarysustem.models;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Newspapers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long indx;

    private Long iisn;

    private String name;

    private String informationAbout;

    private String lang;

    private Long count;

    private Float price;

    @ManyToOne
    private BooksCategories categories;

    private String place;

    private String publisher;

    private Date year;

    @ManyToOne
    private BasicUsers employee;

    public Newspapers(Long indx, Long iisn, String name, String informationAbout, String lang, Long count, Float price, BooksCategories categories, String place, String publisher, Date year, BasicUsers employee) {
        this.indx = indx;
        this.iisn = iisn;
        this.name = name;
        this.informationAbout = informationAbout;
        this.lang = lang;
        this.count = count;
        this.price = price;
        this.categories = categories;
        this.place = place;
        this.publisher = publisher;
        this.year = year;
        this.employee = employee;
    }

    public Newspapers(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIndex() {
        return indx;
    }

    public void setIndex(Long indx) {
        this.indx = indx;
    }

    public Long getIisn() {
        return iisn;
    }

    public void setIisn(Long iisn) {
        this.iisn = iisn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformationAbout() {
        return informationAbout;
    }

    public void setInformationAbout(String informationAbout) {
        this.informationAbout = informationAbout;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public BooksCategories getCategories() {
        return categories;
    }

    public void setCategories(BooksCategories categories) {
        this.categories = categories;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public BasicUsers getEmployee() {
        return employee;
    }

    public void setEmployee(BasicUsers employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Newspapers that = (Newspapers) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
