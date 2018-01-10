package com.vea.zoo.Zoo.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "SOLDTICKETS")
public class SoldTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soldTicket", nullable = false)
    private Ticket soldTicket;

    @Column(name = "PURCHASEDATE")
    private Date purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooSoldTicketVisitor", nullable = false)
    private Visitor zooSoldTicketVisitor;

    public SoldTickets() {
    }
    public Ticket getSoldTicket() {
        return soldTicket;
    }

    public void setSoldTicket(Ticket soldTicket) {
        this.soldTicket = soldTicket;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public SoldTickets(Ticket ticket, Visitor visitor) {
        this.zooSoldTicketVisitor = visitor;
        this.soldTicket = ticket;
        this.purchaseDate = new Timestamp(System.currentTimeMillis());
    }

    public Visitor getZooSoldTicketVisitor() {
        return zooSoldTicketVisitor;
    }

    public void setZooSoldTicketVisitor(Visitor zooSoldTicketVisitor) {
        this.zooSoldTicketVisitor = zooSoldTicketVisitor;
    }
}
