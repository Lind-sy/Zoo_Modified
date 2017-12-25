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
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "animalZone")
    private Long  animalZoneId ;
    @Column(name = "purchaseDate")
    private Date purchaseDate;
    @Column(name = "price")
    private double price;
    @Column(name = "status")
    private Boolean status;

    public Boolean getStatus() {
        return status;
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

    public Long getAnimalZoneId() {
        return animalZoneId;
    }

    /**
     * Method that determind if ticket is valid
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

    /**
     * Method that shows information about tickets zone and state
     */
    public void printTicketStatus() {
        System.out.println("Your " + animalZoneId + " zone ticket is active: " + isTicketValid());
    }

    public Ticket(TicketBuilder builder) {
        this.animalZoneId = builder.animalZoneId;
        this.purchaseDate = builder.purchaseDate;
        this.price = builder.price;
    }

    public static class TicketBuilder {
        private Long animalZoneId;
        private Date purchaseDate;
        private double price;

        public TicketBuilder price(double price){
            this.price = price;
            return this;
            }

        public TicketBuilder animalZone(Long zone) {

                this.animalZoneId = zone;

            return this;
        }

        public TicketBuilder date(Date purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }

        public TicketBuilder() {
            this.purchaseDate = Calendar.getInstance().getTime();
        }

   }
}
