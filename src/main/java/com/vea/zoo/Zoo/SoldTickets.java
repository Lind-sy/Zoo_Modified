package com.vea.zoo.Zoo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "SOLDTICKETS")
public class SoldTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public SoldTickets(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor", nullable = false)
    private Visitor visitor;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket", nullable = false)
    private Ticket ticket;

    @Column(name = "PURCHASEDATE")
    private Date purchaseDate;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


}
