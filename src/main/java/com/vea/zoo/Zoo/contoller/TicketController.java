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
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.LinkedList;
import java.util.List;
@Controller("/ticketStatistics")
@Transactional
@EnableWebMvc
public class TicketController {
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private SoldTicketDao soldTicketDao;
    @Autowired
    private VisitorDao visitorDao;

    @RequestMapping(value ="/ticketStatistics", method = RequestMethod.GET)
    public String getsoldtickets(Model model)
    {
      List<SoldTickets> soldTicketsList = (List<SoldTickets>) soldTicketDao.findAll();
      List<Ticket> tickets = new LinkedList<>();
      for (SoldTickets sold:soldTicketsList
             ) {
            tickets.add(ticketDao.findOne(sold.getTicket()));
        }
        model.addAttribute("ticketList",ticketDao.findAll());
//        model.addAttribute("ticketList",tickets);
      return "ticketStatistics";
    }
//    @RequestMapping("/ticketStatistics" )
//    public String getsoldvisitors(Model model)
//    {
//        List<SoldTickets> soldTicketsList = (List<SoldTickets>) soldTicketDao.findAll();
//        List<Visitor> visitors = new LinkedList<>();
//        for (SoldTickets sold:soldTicketsList
//                ) {
//            visitors.add(visitorDao.findOne(sold.getVisitor()));
//        }
//       model.addAttribute("visitorList",visitors);
//        return "visitorList";
//    }
//    @RequestMapping(value = "/ticketStatistics" , method = RequestMethod.GET)
//    @ModelAttribute("visitorList")
//    public List<Visitor> getsoldvisitors()
//    {
//        List<SoldTickets> soldTicketsList = (List<SoldTickets>) soldTicketDao.findAll();
//        List<Visitor> visitors = new LinkedList<>();
//        for (SoldTickets sold:soldTicketsList
//                ) {
//            visitors.add(visitorDao.findOne(sold.getVisitor()));
//        }
//        return visitors;
//    }
//
//    @RequestMapping(value = "/newTicket", method = RequestMethod.POST)
//    public ResponseEntity addTicket(@RequestParam("zone") final String zone,
//                                    @RequestParam("price") final String price) {
//        //  ticketDao.save(new Ticket(zone, price));
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
