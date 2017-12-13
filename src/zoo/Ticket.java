package zoo;

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
public class Ticket {

    private static AnimalZone animalZone = new AnimalZone();
    private Date purchaseDate;
    private double price;

    public double getPrice() {
        return price;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public String getAnimalZone() {
        return animalZone.getZone();
    }

    /**
     * Method that determind if ticket is valid
     * @return true - if ticket is active, false - if ticket is not active
     */
    public boolean isTicketValid() {
        if (purchaseDate != Calendar.getInstance().getTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that shows information about tickets zone and state
     */
    public void printTicketStatus() {
        System.out.println("Your " + animalZone.getZone() + " zone ticket is active: " + isTicketValid());
    }

    public Ticket(TicketBuilder builder) {
        this.animalZone = builder.animalZone;
        this.purchaseDate = builder.purchaseDate;
        this.price = builder.price;
    }

    public static class TicketBuilder {
        private static AnimalZone animalZone = new AnimalZone();
        private Date purchaseDate;
        private double price;

        public TicketBuilder price(double price){
            this.price = price;
            return this;
            }

        public TicketBuilder animalZone(String zone) {

                this.animalZone.setZone(zone);

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
