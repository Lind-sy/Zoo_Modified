package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.SoldTickets;
import com.vea.zoo.Zoo.Model.Ticket;
import com.vea.zoo.Zoo.Model.Visitor;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.TicketDao;
import com.vea.zoo.Zoo.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldTicketService {
    private SoldTicketDao soldTicketDao;
    private TicketDao ticketDao;
    private VisitorDao visitorDao;
    @Autowired
    public SoldTicketService( final SoldTicketDao soldTicketDao, final TicketDao ticketDao, final VisitorDao visitorDao) {
        this.soldTicketDao = soldTicketDao;
        this.ticketDao = ticketDao;
        this.visitorDao = visitorDao;
    }
    public List<SoldTickets> getAllSoldTickets(){
        return (List<SoldTickets>) soldTicketDao.findAll();
    }
    public List<SoldTickets> getActiveTickets(){
        return (List<SoldTickets>) soldTicketDao.findAllActiveTickets();
    }

    public void saveSoldTicket(Long visitorId, Ticket ticket){
        Visitor visitor = (Visitor) visitorDao.findOne(visitorId);
        soldTicketDao.save(new SoldTickets(ticket ,visitor));
    }
}
