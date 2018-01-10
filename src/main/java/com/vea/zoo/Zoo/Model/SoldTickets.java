package com.vea.zoo.Zoo.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "SOLDTICKETS")
public class SoldTickets {
    public SoldTickets() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public SoldTickets(Ticket ticket, Visitor visitor) {
        this.zooSoldTicketVisitor = visitor;
        this.zooTicket = ticket;
        this.purchaseDate = new Timestamp(System.currentTimeMillis());
    }

    public Ticket getZooTicket() {
        return zooTicket;
    }

    public void setZooTicket(Ticket zooTicket) {
        this.zooTicket = zooTicket;
    }

    public Visitor getZooSoldTicketVisitor() {
        return zooSoldTicketVisitor;
    }

    public void setZooSoldTicketVisitor(Visitor zooSoldTicketVisitor) {
        this.zooSoldTicketVisitor = zooSoldTicketVisitor;
    }

//    public Visitor getZooVisitor() {
//        return zooVisitor;
//    }
//
//    public void setZooVisitor(Visitor zooVisitor) {
//        this.zooVisitor = zooVisitor;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooTicket", nullable = false)
    private Ticket zooTicket;

    @Column(name = "PURCHASEDATE")
    private Date purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooSoldTicketVisitor", nullable = false)
    private Visitor zooSoldTicketVisitor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Ticket getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(Ticket ticket) {
//        this.ticket = ticket;
//    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

//    public Visitor getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(Visitor visitor) {
//        this.visitor = visitor;
//    }


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
