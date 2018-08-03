package com.sberteam.librarysustem.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Parties
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long partyNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    @ManyToOne
    @JoinColumn(name = "source_doctypes_id")
    private DocTypes sourceDocType;

    private String note;

    private Long docNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateByDoc;

    @ManyToOne
    @JoinColumn(name = "doctypes_id")
    private DocTypes docTypes; //New

    private Integer count;

    private Float sum;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Providers provider; //new

    private String address;

    private String transfer;

    public Parties(Long partyNum, Date deliveryDate, DocTypes sourceDocType, String note, Long docNum, Date dateByDoc, DocTypes docTypes, Integer count, Float sum, Providers provider, String address, String transfer) {
        this.partyNum = partyNum;
        this.deliveryDate = deliveryDate;
        this.sourceDocType = sourceDocType;
        this.note = note;
        this.docNum = docNum;
        this.dateByDoc = dateByDoc;
        this.docTypes = docTypes;
        this.count = count;
        this.sum = sum;
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

    public Long getPartyNum() {
        return partyNum;
    }

    public void setPartyNum(Long partyNum) {
        this.partyNum = partyNum;
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

    public Long getDocNum() {
        return docNum;
    }

    public void setDocNum(Long docNum) {
        this.docNum = docNum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }
}
