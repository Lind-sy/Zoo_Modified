package com.vea.zoo.Zoo;

import javax.persistence.*;
import java.text.DecimalFormat;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animalzone", nullable = false)
    private AnimalZone animalZone;

    @Column(name = "PURCHASEDATE")
    private Date purchaseDate;

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
            mappedBy = "ticket")
    private Set<SoldTickets> soldTickets = new HashSet<>();


    public Ticket(){

    }
    public void setId(Long id) {
        this.id = id;
    }

    public AnimalZone getAnimalZone() {
        return animalZone;
    }

    public void setAnimalZone(AnimalZone animalZone) {
        this.animalZone = animalZone;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public Date getPurchaseDate() {
        return purchaseDate;
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
        if (purchaseDate != Calendar.getInstance().getTime()) {
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
