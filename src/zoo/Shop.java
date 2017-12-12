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

    public void checkTicketStatus(Ticket ticket) {
        ticket.printTicketStatus();
    }

    public void checkAllTicketStatuses(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList
                ) {
            ticket.printTicketStatus();
        }
    }

    public void giveToCustomerVoucher(Visitor visitor, int discountType) {
        visitor.addVoucher(new Voucher(discountType));
    }

    public void sellTicketAddingVoucher(Visitor visitor, String animalZone, String voucherCode) {
        visitor.addTicket(new Ticket(new Ticket.TicketBuilder()
                .animalZone(animalZone)
                .price(priceCalculator.calculateTotalPriceWithVoucher(visitor, animalZone, visitor.findVoucher(voucherCode)
                ))));
        removeVoucher(visitor, voucherCode);
    }

    public void sellTicketWithoutVoucher(Visitor visitor, String animalZone) {

        visitor.addTicket(new Ticket(new Ticket.TicketBuilder()
                .animalZone(animalZone)
                .price(priceCalculator.calculateTotalPriceWithoutVoucher(visitor, animalZone)
                )));
    }

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
