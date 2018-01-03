package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Services.SoldTicketService;
import com.vea.zoo.Zoo.Services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VisitorController {

    private VisitorService visitorService;

    @Autowired
    public VisitorController(final VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @RequestMapping(value = "/visitorStatistic", method = RequestMethod.GET)
    public String showAllVisitors(Model model) {
        model.addAttribute("visitorList", visitorService.getAllVisitors());
        return "visitorStatistic";
    }

    @RequestMapping(value = "/newVisitor/create", method = RequestMethod.POST)
    public ResponseEntity createVisitor(
            @RequestParam("name") final String name,
            @RequestParam("humanCategory") final String humanCategory) {
        visitorService.saveVisitor(name, humanCategory);
        return new ResponseEntity(HttpStatus.OK);
    }
}
