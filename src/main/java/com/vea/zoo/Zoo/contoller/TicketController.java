package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Services.SoldTicketService;
import com.vea.zoo.Zoo.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/createTicket", method = RequestMethod.POST)
    public String createTicket(@RequestParam("visitorId") final Long visitorId,
                               @RequestParam("zoneName")String zoneName){
        boolean canBuyTicket = ticketService.canBuyTicket(visitorId,zoneName);
        if(canBuyTicket == true){
            ticketService.createTicket(zoneName,visitorId);
        }else{
        }
        return "/createTicket";
    }
    @RequestMapping(value = "/createTicketWithVoucher", method = RequestMethod.POST)
    public String createTicketWithVoucher(@RequestParam("visitorId") final Long visitorId,
                               @RequestParam("zoneName")String zoneName, @RequestParam("voucherCode")String code){
        boolean canBuyTicket = ticketService.canBuyTicket(visitorId,zoneName);
        if(canBuyTicket == true){
            ticketService.createTicket(zoneName,visitorId);
        }else{
        }
        return "/createTicketWithVoucher";
    }


    //Made For testing purposes - Service method could be used in ticket buying logic
    @RequestMapping(value = "/addSoldTickets", method = RequestMethod.POST)
    public String saveSoldTicket(@RequestParam("visitorId") final Long visitorId,
                                @RequestParam("ticketId")final Long ticketId){
        soldTicketService.saveSoldTicket(visitorId,ticketId);
        return "/addSoldTickets";
    }
}

