package com.sberteam.librarysustem.models;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    //Отрасль
    @ManyToOne
    @JoinColumn(name = "category_id")
    private BooksCategories bookCategory;

    private String publisher;

    @DateTimeFormat(pattern = "YYYY")
    private Date year;

    private String publicationPlace;

    private Long tom_number;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private BooksMaps map;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private BooksLevels level;

    private Integer count;

    private Float price;

    private Float sum;

    private Long transferNumber;

    @ManyToOne
    @JoinColumn(name="party_id")
    private Parties party;

    public Books() {

    }

    public Books(String name, String author, BooksCategories bookCategory, String publisher,
                 Date year, String publicationPlace, Long tom_number, BooksMaps map, BooksLevels level,
                 Integer count, Float price, Long transferNumber, Parties party) {
        this.name = name;
        this.author = author;
        this.bookCategory = bookCategory;
        this.publisher = publisher;
        this.year = year;
        this.publicationPlace = publicationPlace;
        this.tom_number = tom_number;
        this.map = map;
        this.level = level;
        this.count = count;
        this.price = price;
        this.sum = count*price;
        this.transferNumber = transferNumber;
        this.party = party;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BooksCategories getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BooksCategories bookCategory) {
        this.bookCategory = bookCategory;
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

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    public Long getTom_number() {
        return tom_number;
    }

    public void setTom_number(Long tom_number) {
        this.tom_number = tom_number;
    }

    public BooksMaps getMap() {
        return map;
    }

    public void setMap(BooksMaps map) {
        this.map = map;
    }

    public BooksLevels getLevel() {
        return level;
    }

    public void setLevel(BooksLevels level) {
        this.level = level;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = this.price*this.count;
    }

    public Long getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(Long transferNumber) {
        this.transferNumber = transferNumber;
    }

    public Parties getParty() {
        return party;
    }

    public void setParty(Parties party) {
        this.party = party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        return id.equals(books.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookCategory=" + bookCategory.getId()     +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", publicationPlace='" + publicationPlace + '\'' +
                ", tom_number=" + tom_number +
                ", map=" + map.getId() +
                ", level=" + level.getId() +
                ", count=" + count +
                ", price=" + price +
                ", sum=" + sum +
                ", transferNumber=" + transferNumber +
                ", party=" + party +
                '}';
    }
}
