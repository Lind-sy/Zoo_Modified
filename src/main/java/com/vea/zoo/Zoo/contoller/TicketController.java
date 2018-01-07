package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Services.SoldTicketService;
import com.vea.zoo.Zoo.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TicketController {

    private SoldTicketService soldTicketService;
    private TicketService ticketService;

    @Autowired
    public TicketController(final SoldTicketService soldTicketService,
                            final TicketService ticketService) {
        this.soldTicketService = soldTicketService;
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/ticketStatistics", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        model.addAttribute("ticketList",soldTicketService.getActiveTickets());
        return "ticketStatistics";
    }
}
