package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.SoldTickets;
import com.vea.zoo.Zoo.Ticket;
import com.vea.zoo.Zoo.Visitor;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.TicketDao;
import com.vea.zoo.Zoo.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

public class TicketController {
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private SoldTicketDao soldTicketDao;
    @Autowired
    private VisitorDao visitorDao;

    @RequestMapping(value = "/ticketStatistic" , method = RequestMethod.GET)
    @ModelAttribute("ticketList")
    public List<Ticket> getsoldtickets()
    {
      List<SoldTickets> soldTicketsList = (List<SoldTickets>) soldTicketDao.findAll();
      List<Ticket> tickets = new LinkedList<>();
      for (SoldTickets sold:soldTicketsList
             ) {
            tickets.add(ticketDao.findOne(sold.getTicket()));
        }
        return tickets;
    }

    @RequestMapping(value = "/ticketStatistic" , method = RequestMethod.GET)
    @ModelAttribute("visitorList")
    public List<Visitor> getsoldvisitors()
    {
        List<SoldTickets> soldTicketsList = (List<SoldTickets>) soldTicketDao.findAll();
        List<Visitor> visitors = new LinkedList<>();
        for (SoldTickets sold:soldTicketsList
                ) {
            visitors.add(visitorDao.findOne(sold.getVisitor()));
        }
        return visitors;
    }
//
//    @RequestMapping(value = "/newTicket", method = RequestMethod.POST)
//    public ResponseEntity addTicket(@RequestParam("zone") final String zone,
//                                    @RequestParam("price") final String price) {
//        //  ticketDao.save(new Ticket(zone, price));
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
