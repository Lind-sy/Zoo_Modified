package com.vea.zoo.Zoo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "SOLDTICKETS")
public class SoldTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "VISITOR")
    private Long visitor;
    @Column(name = "TICKET")
    private Long ticket;
    @Column(name = "PURCHASEDATE")
    private Date purchaseDate;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitor() {
        return visitor;
    }

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }


}
