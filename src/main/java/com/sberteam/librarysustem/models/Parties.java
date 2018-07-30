package com.sberteam.librarysustem.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Parties
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    @ManyToOne
    @JoinColumn(name = "source_doctypes_id")
    private DocTypes sourceDocType;

    private String note;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateByDoc;

    @ManyToOne
    @JoinColumn(name = "doctypes_id")
    private DocTypes docTypes; //New

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Providers provider; //new

    private String address;

    private String transfer;

    public Parties(String name, Date deliveryDate, DocTypes sourceDocType, String note, Date dateByDoc, DocTypes docTypes, Providers provider, String address, String transfer) {
        this.name = name;
        this.deliveryDate = deliveryDate;
        this.sourceDocType = sourceDocType;
        this.note = note;
        this.dateByDoc = dateByDoc;
        this.docTypes = docTypes;
        this.provider = provider;
        this.address = address;
        this.transfer = transfer;
    }

    public Parties() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parties parties = (Parties) o;

        return id.equals(parties.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
