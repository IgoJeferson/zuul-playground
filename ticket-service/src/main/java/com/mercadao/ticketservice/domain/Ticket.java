package com.mercadao.ticketservice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TICKETS")
@Entity
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id//Pk
    @Column(name = "TICKET_ID")
    private Integer ticketId;

    @Column(name = "NUMERO_PREMIADO")
    private Integer numeroPremiado;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    public Ticket() {
        super();
    }

    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticketId + ", numeroPremiado=" + numeroPremiado + ", status=" + status
                + ", productId=" + productId + "]";
    }

    public Ticket(Integer ticketId, Integer numeroPremiado, String status, Integer productId) {
        super();
        this.ticketId = ticketId;
        this.numeroPremiado = numeroPremiado;
        this.status = status;
        this.productId = productId;
    }


    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNumeroPremiado() {
        return numeroPremiado;
    }

    public void setNumeroPremiado(Integer numeroPremiado) {
        this.numeroPremiado = numeroPremiado;
    }
}