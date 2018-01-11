package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.*;
import com.vea.zoo.Zoo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private PriceCalculator priceCalculator = new PriceCalculator();
    private TicketDao ticketDao;
    private SoldTicketDao soldTicketDao;
    private AnimalZoneDao animalZoneDao;
    private VisitorDao visitorDao;
    private VoucherDao voucherDao;
    @Autowired
    public TicketService(final TicketDao ticketDao,
                         final SoldTicketDao soldTicketDao,
                         final  AnimalZoneDao animalZoneDao,
                         final VisitorDao visitorDao,
                         final VoucherDao voucherDao) {
//        this.priceCalculator = priceCalculator;
        this.ticketDao = ticketDao;
        this.soldTicketDao = soldTicketDao;
        this.animalZoneDao = animalZoneDao;
        this.visitorDao = visitorDao;
        this.voucherDao = voucherDao;
    }

    //TO DO...check if visitor already has this ticket and it is valid
    public Ticket createTicket(String zoneName, Long visitorId){
        Visitor visitor = visitorDao.findOne(visitorId);
        priceCalculator.calculateTotalPriceWithoutVoucher(visitor, zoneName);
        Double price = priceCalculator.totalPrice;
        Ticket ticket = new Ticket(animalZoneDao.findByZone(zoneName).get(0), price);
        ticketDao.save(ticket);
        List<Ticket> ticketList = ticketDao.findAllSorted();
        return ticketList.get(0);
    }

    //TO DO...check if visitor already has this ticket and it is valid
    public Ticket createTicketWithVoucher(String zoneName, Long visitorId, String code){
        Visitor visitor = visitorDao.findOne(visitorId);
        Voucher voucher = voucherDao.findByCode(code).get(0);
        priceCalculator.calculateTotalPriceWithVoucher(visitor,zoneName,voucher);
        Double price = priceCalculator.totalPrice;
        Ticket ticket = new Ticket(animalZoneDao.findByZone(zoneName).get(0), price);
        ticketDao.save(ticket);
        List<Ticket> ticketList = ticketDao.findAllSorted();
        return ticketList.get(0);
    }

    /**
     * Method that determind if ticket is valid
     * @return true - if ticket is active, false - if ticket is not active
     */
    public boolean isTicketValid(Ticket ticket) {
        if (ticket.getUsageDate().equals(Calendar.getInstance().getTime())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canBuyTicket(Long visitorId, String animalZone){
        List<Ticket> boughtTicketList  = getVisitorsBoughtTickets(visitorId);
        for (Ticket t: boughtTicketList
             ) {
            if((t.getStatus() == true && isTicketValid(t)) && t.getTicketAnimalZone().getZone().equals(animalZone)){
            return false;
            }
        }
        return true;
    }

    public void setTicketStatusToFalse(Long visitorId){

       List<Ticket> updatedTicketList  = getVisitorsBoughtTickets(visitorId);
       updatedTicketList.forEach(t -> t.setStatus(false));
       ticketDao.save(updatedTicketList);
    }

    public List<Ticket> getVisitorsBoughtTickets(Long visitorId){
        List<SoldTickets> soldTickets = soldTicketDao.findByVisitorId(visitorId);
        List<Ticket> ticketList = (List<Ticket>) ticketDao.findAll();

        List<Ticket> visitorsTickets  = ticketList.stream()
                .filter(e -> (soldTickets.stream()
                        .filter(d -> d.getSoldTicket().getId().equals(e.getId()))
                        .count())>0)
                .collect(Collectors.toList());

        return visitorsTickets;
    }
}
