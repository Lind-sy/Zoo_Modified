package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.SoldTickets;
import com.vea.zoo.Zoo.Model.Ticket;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void setTicketStatusToFalse(Long visitorId){
       List<SoldTickets> soldTickets = soldTicketDao.findByVisitorId(visitorId);
       List<Ticket> ticketList = (List<Ticket>) ticketDao.findAll();

       List<Ticket> updatedTicketList  = ticketList.stream()
                .filter(e -> (soldTickets.stream()
                        .filter(d -> d.getZooTicket().getId().equals(e.getId()))
                        .count())>0)
                .collect(Collectors.toList());

       updatedTicketList.forEach(t -> t.setStatus(false));
       ticketDao.save(updatedTicketList);
    }
}
