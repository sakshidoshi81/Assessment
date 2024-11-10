package com.etiqa.infrastructure.entities;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", unique = true, nullable = false)
    private Long custId;

    @Column(name = "cust_first_name")
    private String custfirstName;
    
    @Column(name = "cust_last_name")
    private String custLastName;

    @Column(name = "cust_mob_no")
    private String custMobNo;
    
    @Column(name = "cust_email")
    private String custEmail;
    
    @Column(name = "cust_status")
    private Boolean custStatus;

    @JsonFormat(pattern = "dd MMM yyyy hh:mm:ss")
    @Column(name = "cust_created_date")
    private Timestamp custCreatedDate;


    @ManyToMany(cascade = CascadeType.DETACH, fetch=FetchType.LAZY)
    @JoinTable(name = "Customer_Product", joinColumns = @JoinColumn(name = "cust_id", referencedColumnName = "cust_id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"))
    @JsonIgnore
    private List<Product> products;


    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustFirstName() {
        return custfirstName;
    }

    public void setCustFirstName(String custfirstName) {
        this.custfirstName = custfirstName;
    }

    public String getCustMobNo() {
        return custMobNo;
    }

    public void setCustMobNo(String custMobNo) {
        this.custMobNo = custMobNo;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public Boolean getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(Boolean custStatus) {
        this.custStatus = custStatus;
    }

    public Timestamp getCustCreatedDate() {
        return custCreatedDate;
    }

    public void setCustCreatedDate(Timestamp custCreatedDate) {
        this.custCreatedDate = custCreatedDate;
    }
}