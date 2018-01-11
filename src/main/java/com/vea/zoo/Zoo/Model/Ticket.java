package com.vea.zoo.Zoo.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Martins Buhanovskis
 * Ticket class.
 * Ticket:
 * * ticket output: ticketOutput(type,date)
 * * add ticket: addTicket(Ticket ticket)
 * * get tickets: getTickets()
 * * ticket builder(nested class Builder)
 */

@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketAnimalZone", nullable = false)
    private AnimalZone ticketAnimalZone;

    @Column(name = "USAGEDATE")
    private LocalDate usageDate;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STATUS")
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "soldTicket")
    private Set<SoldTickets> soldTickets = new HashSet<>();

    public Ticket(){

    }

    public Ticket(AnimalZone ticketAnimalZone, Double price) {
        this.status = true;
        this.usageDate = new Timestamp(System.currentTimeMillis()).toLocalDateTime().toLocalDate();
        this.ticketAnimalZone = ticketAnimalZone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public AnimalZone getTicketAnimalZone() {
        return ticketAnimalZone;
    }

    public void setTicketAnimalZone(AnimalZone ticketAnimalZone) {
        this.ticketAnimalZone = ticketAnimalZone;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<SoldTickets> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Set<SoldTickets> soldTickets) {
        this.soldTickets = soldTickets;
    }
}
