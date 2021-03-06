package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Model.Ticket;
import com.vea.zoo.Zoo.Services.SoldTicketService;
import com.vea.zoo.Zoo.Services.SoldVoucherService;
import com.vea.zoo.Zoo.Services.TicketService;
import com.vea.zoo.Zoo.Services.VisitorService;
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
    private SoldVoucherService soldVoucherService;

    @Autowired
    public TicketController(final SoldTicketService soldTicketService,
                            final TicketService ticketService,
                            final SoldVoucherService soldVoucherService) {
        this.soldTicketService = soldTicketService;
        this.ticketService = ticketService;
        this.soldVoucherService = soldVoucherService;
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
            Ticket ticket = ticketService.createTicket(zoneName,visitorId);
            soldTicketService.saveSoldTicket(visitorId,ticket);
            return "/createTicket";
        }else{
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/createTicketWithVoucher", method = RequestMethod.POST)
    public String createTicketWithVoucher(@RequestParam("visitorId") final Long visitorId,
                               @RequestParam("zoneName")String zoneName, @RequestParam("voucherCode")String code){
        boolean canBuyTicket = ticketService.canBuyTicket(visitorId,zoneName);
        boolean hasVoucher = soldVoucherService.hasVoucher(visitorId, code);
        if(canBuyTicket == true && hasVoucher == true){
            ticketService.createTicketWithVoucher(zoneName,visitorId,code);
            soldVoucherService.deleteUsedVoucher(visitorId, code);
            return "/createTicketWithVoucher";
        }else{
            return "/errorPage";
        }
    }
}

