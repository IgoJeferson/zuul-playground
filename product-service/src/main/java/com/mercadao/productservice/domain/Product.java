package com.mercadao.productservice.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table(name = "PRODUCT")
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id//Pk
    @Column(name = "PRODUCT_ID")
    Integer productId;

    @Column(name = "PRODUCT_NAME")
    String productName;

    @Transient
    Ticket ticket;

    public Product() {
    }

    public Product(Integer productId, String productName) {
        super();
        this.productId = productId;
        this.productName = productName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}