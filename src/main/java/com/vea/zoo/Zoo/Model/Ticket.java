package com.vea.zoo.Zoo.Model;

import com.vea.zoo.Zoo.Model.AnimalZone;
import com.vea.zoo.Zoo.Model.SoldTickets;

import javax.persistence.*;
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

    public AnimalZone getTicketAnimalZone() {
        return ticketAnimalZone;
    }

    public void setTicketAnimalZone(AnimalZone ticketAnimalZone) {
        this.ticketAnimalZone = ticketAnimalZone;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketAnimalZone", nullable = false)
    private AnimalZone ticketAnimalZone;

    @Column(name = "USAGEDATE")
    private Date usageDate;

    public Set<SoldTickets> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Set<SoldTickets> soldTickets) {
        this.soldTickets = soldTickets;
    }

    @Column(name = "PRICE")
    private Double price;



    @Column(name = "STATUS")
    private Boolean status;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "zooTicket")
    private Set<SoldTickets> soldTickets = new HashSet<>();


    public Ticket(){

    }
    public void setId(Long id) {
        this.id = id;
    }

//    public AnimalZone getAnimalZone() {
//        return animalZone;
//    }
//
//    public void setAnimalZone(AnimalZone animalZone) {
//        this.animalZone = animalZone;
//    }

//    public void setPurchaseDate(Date purchaseDate) {
//        this.purchaseDate = purchaseDate;
//    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

//    public Date getPurchaseDate() {
//        return purchaseDate;
//    }


    public Date getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(Date usageDate) {
        this.usageDate = usageDate;
    }

    public Boolean getStatus() {
        return isTicketValid();
    }

    public Long getId() {
        return id;
    }

    /**
     * Method that determind if ticket is valid
     *
     * @return true - if ticket is active, false - if ticket is not active
     */
    public boolean isTicketValid() {
        if (usageDate != Calendar.getInstance().getTime()) {
            setStatus(true);
            return true;
        } else {
            setStatus(false);
            return false;
        }
    }

//    /**
//     * Method that shows information about tickets zone and state
//     */
//    public void printTicketStatus() {
//        System.out.println("Your " + animalZone + " zone ticket is active: " + isTicketValid());
//    }
//
//    public Ticket(TicketBuilder builder) {
//        this.animalZone = builder.animalZone;
//        this.purchaseDate = builder.purchaseDate;
//        this.price = builder.price;
//        this.status = builder.status;
//    }
//
//    public static class TicketBuilder {
//        private AnimalZone animalZone;
//        private Date purchaseDate;
//        private double price;
//        private Boolean status;
//
//        public TicketBuilder price(double price) {
//            this.price = price;
//            return this;
//        }
//
//        public TicketBuilder animalZone(AnimalZone zone) {
//            this.animalZone = zone;
//            return this;
//        }
//
//        public TicketBuilder date(Date purchaseDate) {
//            this.purchaseDate = purchaseDate;
//            return this;
//        }
//
//        public TicketBuilder status(Boolean status) {
//            this.status = status;
//            return this;
//        }
//
//        public TicketBuilder() {
//            this.purchaseDate = Calendar.getInstance().getTime();
//            this.status = true;
//        }
//    }
}
