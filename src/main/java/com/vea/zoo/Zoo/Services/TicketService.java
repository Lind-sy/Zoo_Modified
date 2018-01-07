package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.dao.AnimalZoneDao;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
