package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Model.AnimalZone;
import com.vea.zoo.Zoo.Model.Visitor;
import com.vea.zoo.Zoo.Services.AnimalZoneService;
import com.vea.zoo.Zoo.Services.SoldTicketService;
import com.vea.zoo.Zoo.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    private SoldTicketService soldTicketService;
    private TicketService ticketService;
    private AnimalZoneService animalZoneService;

    @Autowired
    public TicketController(final SoldTicketService soldTicketService,
                            final TicketService ticketService,
                            final AnimalZoneService animalZoneService) {
        this.soldTicketService = soldTicketService;
        this.ticketService = ticketService;
        this.animalZoneService = animalZoneService;
    }

    @RequestMapping(value = "/ticketStatistics", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        model.addAttribute("ticketList",soldTicketService.getActiveTickets());
        return "ticketStatistics";
    }

    @RequestMapping(value = "/createTicket", method = RequestMethod.POST)
    public String updateVisitor(@RequestParam("visitorId") final Long visitorId,
                                @RequestParam("zoneName")String zoneName){
        ticketService.createTicket(zoneName,visitorId);
        return "/createTicket";
    }

    //Made For testing purposes - Service method could be used in ticket buying logic
    @RequestMapping(value = "/addSoldTickets", method = RequestMethod.POST)
    public String updateVisitor(@RequestParam("visitorId") final Long visitorId,
                                @RequestParam("ticketId")final Long ticketId){
        soldTicketService.saveSoldTicket(visitorId,ticketId);
        return "/addSoldTickets";
    }
    @GetMapping("/addAnimalZone")
    public String animalZoneAddForm(Model model) {
        model.addAttribute("animalzone", new AnimalZone());
        return "addAnimalZone";
    }
    @RequestMapping(value = "/createAnimalZone", method = RequestMethod.POST)
    public String createAnimalZone(@RequestParam("zone") final String zoneName){
        animalZoneService.createAnimalZone(zoneName);
        return "createAnimalZone";
    }
}

