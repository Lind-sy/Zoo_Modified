package zoo;

import java.util.Iterator;
import java.util.List;

/**
 * @author Martins Buhanovskis
 * <p>
 * Shop:
 * * visitor buys ticket
 * * checks visitors ticket
 */

public class Shop {
    public static PriceCalculationService priceCalculator = new PriceCalculator();

    /**
     * Method that displays infrormation about one user ticket
     * @param ticket for certain user
     */
    public void checkTicketStatus(Ticket ticket) {
        ticket.printTicketStatus();
    }

    /**
     * Method that displays infrormation about all user tickets
     * @param ticketList for certain user
     */
    public void checkAllTicketStatuses(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList
                ) {
            ticket.printTicketStatus();
        }
    }

    /**
     * Method that gives customer a voucher
     * @param visitor - certain user
     * @param discountType - how big is the discount
     */
    public void giveToCustomerVoucher(Visitor visitor, int discountType) {
        visitor.addVoucher(new Voucher(discountType));
    }

    /**
     * Method that created a ticket and gives it to visitor ticket list
     * @param visitor
     * @param animalZone
     * @param voucherCode
     */
    public void sellTicketAddingVoucher(Visitor visitor, String animalZone, String voucherCode) {
        visitor.addTicket(new Ticket(new Ticket.TicketBuilder()
                .animalZone(animalZone)
                .price(priceCalculator.calculateTotalPriceWithVoucher(visitor, animalZone, visitor.findVoucher(voucherCode)
                ))));
        removeVoucher(visitor, voucherCode);
    }

    /**
     * Method that creates a ticket and adds it to visitor ticket list
     * @param visitor
     * @param animalZone
     */
    public void sellTicketWithoutVoucher(Visitor visitor, String animalZone) {

        visitor.addTicket(new Ticket(new Ticket.TicketBuilder()
                .animalZone(animalZone)
                .price(priceCalculator.calculateTotalPriceWithoutVoucher(visitor, animalZone)
                )));
    }

    /**
     * Method that removes used voucher from visitor list
     * @param visitor
     * @param code - voucher code
     */
    public void removeVoucher(Visitor visitor, String code) {
        if (!visitor.getVoucherList().isEmpty()) {
            for (Iterator<Voucher> it = visitor.getVoucherList().iterator(); it.hasNext(); ) {
                Voucher voucher = it.next();
                if (voucher.getCode() == code) {
                    it.remove();
                }
            }
        } else {
            throw new IndexOutOfBoundsException("No vouchers for this visitor");
        }
    }
}
