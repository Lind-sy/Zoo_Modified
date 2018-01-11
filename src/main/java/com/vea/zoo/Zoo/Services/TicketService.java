package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.SoldTickets;
import com.vea.zoo.Zoo.Model.Ticket;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private PriceCalculator priceCalculator;
    private TicketDao ticketDao;
    private SoldTicketDao soldTicketDao;
    @Autowired
    public TicketService(final PriceCalculator priceCalculator,
                         final TicketDao ticketDao,
                         final SoldTicketDao soldTicketDao) {
        this.priceCalculator = priceCalculator;
        this.ticketDao = ticketDao;
        this.soldTicketDao = soldTicketDao;
    }

//TO DO...check if visitor already has this ticket and it is valid
    public void createTicket(String zoneName, Long visitorId){

    }

    //TO DO...check if visitor already has this ticket and it is valid
    public void createTicketWithVoucher(String zoneName, Long visitorId, String code){

    }

    /**
     * Method that determind if ticket is valid
     * @return true - if ticket is active, false - if ticket is not active
     */
    public boolean isTicketValid(Ticket ticket) {
        if (ticket.getUsageDate() != Calendar.getInstance().getTime()) {
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
