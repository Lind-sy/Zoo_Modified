package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Model.AnimalZone;
import com.vea.zoo.Zoo.Services.AnimalZoneService;
import com.vea.zoo.Zoo.dao.AnimalZoneDao;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.TicketDao;
import com.vea.zoo.Zoo.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class TicketController {


    private AnimalZoneService animalZoneService;

    @Autowired
    public TicketController(final AnimalZoneService animalZoneService) {
        this.animalZoneService = animalZoneService;
    }

    @RequestMapping(value = "/ticketStatistics", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        model.addAttribute("ticketList",animalZoneService.getAnimalZones() );
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
//    @RequestMapping(value = "/ticketSell", method = RequestMethod.GET)
//    public ResponseEntity addTicket(@RequestParam("zone") final String zone) {
//          animalZoneDao.save(new AnimalZone(zone));
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
