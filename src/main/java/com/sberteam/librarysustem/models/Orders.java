package com.sberteam.librarysustem.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String chb;
    private String reader;
    private String author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BasicUsers user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;
    private String contentsOfSource; // загл. источника
    private String inf; // Инв. №
    private String barcode; // штрих код

    public Orders() {
    }

    public Orders(Date date, String chb, String reader, String author, BasicUsers user, Books book, String contentsOfSource, String inf, String barcode) {
        this.date = date;
        this.chb = chb;
        this.reader = reader;
        this.author = author;
        this.user = user;
        this.book = book;
        this.contentsOfSource = contentsOfSource;
        this.inf = inf;
        this.barcode = barcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getChb() {
        return chb;
    }

    public void setChb(String chb) {
        this.chb = chb;
    }

    public BasicUsers getUser() {
        return user;
    }

    public void setUser(BasicUsers user) {
        this.user = user;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public String getContentsOfSource() {
        return contentsOfSource;
    }

    public void setContentsOfSource(String contentsOfSource) {
        this.contentsOfSource = contentsOfSource;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        return id.equals(orders.id);
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", date='" + date.toString() + '\'' +
                ", №ЧБ='" + chb + '\'' +
                ", ФИО Читателя=" +user.getId() + " " + user.getName()     +
                ", Автор='" + book.getAuthor() + '\'' +
                ", Заглавие=" + book.getName() +
                ", Загл. источника='" + contentsOfSource + '\'' +
                ", Инф. №=" + inf +
                ", Штрих-код=" + barcode +
                '}';
    }
}
