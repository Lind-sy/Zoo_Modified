package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Model.AnimalZone;
import com.vea.zoo.Zoo.Model.SoldTickets;
import com.vea.zoo.Zoo.Services.AnimalZoneService;
import com.vea.zoo.Zoo.Services.SoldTicketService;
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

    private SoldTicketService soldTicketService;

    @Autowired
    public TicketController(final SoldTicketService soldTicketService) {
        this.soldTicketService = soldTicketService;
    }

    @RequestMapping(value = "/ticketStatistics", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        model.addAttribute("ticketList",soldTicketService.getActiveTickets());
        return "ticketStatistics";
    }

    //Just an example how to create animal zone using controller
//    @RequestMapping(value = "/ticketSell", method = RequestMethod.GET)
//    public ResponseEntity addAnimalZone(@RequestParam("zone") final String zone) {
//          animalZoneDao.save(new AnimalZone(zone));
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
