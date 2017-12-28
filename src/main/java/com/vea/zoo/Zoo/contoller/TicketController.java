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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.LinkedList;
import java.util.List;
@Controller
public class TicketController {
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private SoldTicketDao soldTicketDao;
    @Autowired
    private VisitorDao visitorDao;

    @RequestMapping(value = "/ticketStatistics", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        model.addAttribute("ticketList", (List<Ticket>)ticketDao.findAll());
        return "ticketStatistics";
    }

//    @RequestMapping(value ="/ticketStatistics", method = RequestMethod.GET)
//    public String getsoldtickets(Model model)
//    {
////      List<SoldTickets> soldTicketsList = (List<SoldTickets>) soldTicketDao.findAll();
//      List<Ticket> tickets = (List<Ticket>)ticketDao.findAll();
////      for (SoldTickets sold:soldTicketsList
////             ) {
//////            tickets.add();
////        }
//        System.out.println(tickets.size()+"*************");
//        model.addAttribute("ticketList",(List<Ticket>)ticketDao.findAll());
////        model.addAttribute("ticketList",tickets);
//      return "ticketStatistics";
//    }
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
//    @ModelAttribute("ticketList")
//    public List<Ticket> getsoldvisitors()
//    {
////        List<SoldTickets> soldTicketsList = (List<SoldTickets>) soldTicketDao.findAll();
////        List<Visitor> visitors = new LinkedList<>();
////        for (SoldTickets sold:soldTicketsList
////                ) {
////            visitors.add(visitorDao.findOne(sold.getVisitor()));
////        }
//        return (List<Ticket>)ticketDao.findAll();
//    }
//
//    @RequestMapping(value = "/newTicket", method = RequestMethod.POST)
//    public ResponseEntity addTicket(@RequestParam("zone") final String zone,
//                                    @RequestParam("price") final String price) {
//        //  ticketDao.save(new Ticket(zone, price));
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
