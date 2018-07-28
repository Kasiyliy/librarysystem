package com.sberteam.librarysustem.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Parties
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date deliveryDate;

    @ManyToOne
    @JoinColumn(name = "source_doctypes_id")
    private DocTypes sourceDocType;

    private String note;

    private Date dateByDoc;

    @ManyToOne
    @JoinColumn(name = "doctypes_id")
    private DocTypes docTypes; //New

    private Long count;

    private Float sum;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Providers provider; //new

    private String address;

    private String transfer;

    @OneToMany
    @JoinColumn(name = "parties_books")
    private Set<Books> books;

    public Parties(Date deliveryDate, DocTypes sourceDocType, String note, Date dateByDoc, DocTypes docTypes, Long count, Float sum, Providers provider, String address,
                   String transfer, Set<Books> books) {
        this.deliveryDate = deliveryDate;
        this.sourceDocType = sourceDocType;
        this.note = note;
        this.dateByDoc = dateByDoc;
        this.docTypes = docTypes;
        this.count = count;
        this.sum = sum;
        this.provider = provider;
        this.address = address;
        this.transfer = transfer;
        this.books = books;
    }

    public Parties() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public DocTypes getSourceDocType() {
        return sourceDocType;
    }

    public void setSourceDocType(DocTypes sourceDocType) {
        this.sourceDocType = sourceDocType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateByDoc() {
        return dateByDoc;
    }

    public void setDateByDoc(Date dateByDoc) {
        this.dateByDoc = dateByDoc;
    }

    public DocTypes getDocTypes() {
        return docTypes;
    }

    public void setDocTypes(DocTypes docTypes) {
        this.docTypes = docTypes;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Providers getProvider() {
        return provider;
    }

    public void setProvider(Providers provider) {
        this.provider = provider;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}
