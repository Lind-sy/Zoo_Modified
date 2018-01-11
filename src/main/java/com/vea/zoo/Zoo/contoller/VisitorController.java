package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Model.Visitor;
import com.vea.zoo.Zoo.Services.TicketService;
import com.vea.zoo.Zoo.Services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class VisitorController {

    private VisitorService visitorService;
    private TicketService ticketService;

    @Autowired
    public VisitorController(final VisitorService visitorService,
                             final TicketService ticketService) {
        this.visitorService = visitorService;
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/visitorStatistic", method = RequestMethod.GET)
    public String showAllVisitors(Model model) {
        model.addAttribute("visitorList", visitorService.getAllVisitors());
        return "visitorStatistic";
    }

    @GetMapping("/addVisitor")
    public String visitorAddForm(Model model) {
        model.addAttribute("humanCategoryList", visitorService.getAllCategorys());
        model.addAttribute("visitor", new Visitor());
        return "addVisitor";
    }

    @RequestMapping(value = "/createVisitor", method = RequestMethod.POST)
    public String createVisitor(@RequestParam("name") final String name, @RequestParam("visitorHumanCategory")
            final String humanCategory) {
        visitorService.saveVisitor(name, humanCategory);
        return "/visitorStatistic";
    }

    @RequestMapping(value = "/deleteVisitor", method = RequestMethod.POST)
    public String deleteVisitor(@RequestParam("id") final Long visitorId){
        ticketService.setTicketStatusToFalse(visitorId);
        visitorService.deleteVisitor(visitorId);
        return "/deleteVisitor";
    }
    @RequestMapping(value = "/updateVisitor", method = RequestMethod.POST)
    public String updateVisitor(@RequestParam("visitorId") final Long visitorId,
                                @RequestParam("name")String name,
                                @RequestParam("categoryName")String categoryName){
        visitorService.updateVisitor(categoryName,name,visitorId);
        return "/updateVisitor";
    }
}
