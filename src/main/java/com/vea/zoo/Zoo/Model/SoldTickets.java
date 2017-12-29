package com.vea.zoo.Zoo.Model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "SOLDTICKETS")
public class SoldTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket", nullable = false)
    private Ticket ticket;

    @Column(name = "PURCHASEDATE")
    private Date purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor", nullable = false)
    private Visitor visitor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }


    //    public SoldTickets(){}
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Visitor getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(Visitor visitor) {
//        this.visitor = visitor;
//    }


//    public Ticket getTicket() {
//        return ticket;
//    }

//    public void setTicket(Ticket ticket) {
//        this.ticket = ticket;
//    }


//    public Date getPurchaseDate() {
//        return purchaseDate;
//    }

//    public void setPurchaseDate(Date purchaseDate) {
//        this.purchaseDate = purchaseDate;
//    }

//    public SoldTickets(Visitor visitor, Ticket ticket, Date purchaseDate) {
//        this.visitor = visitor;
//        this.ticket = ticket;
//        this.purchaseDate = purchaseDate;
//    }
//
//    public SoldTickets(Visitor visitor, Ticket ticket) {
//        this.visitor = visitor;
//        this.ticket = ticket;
//    }
}
