package com.vea.zoo.Zoo.contoller;


import com.vea.zoo.Zoo.Services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


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
//
    @RequestMapping(value = "/createVisitor", method = RequestMethod.POST)
    public String createVisitor(
            @RequestParam("name")
            final String name,
            @RequestParam("humanCategory")
            final String humanCategory) {
        visitorService.saveVisitor(name, humanCategory);
        return "/createVisitor";
    }
}

//
//@RestController
//@RequestMapping(value = "/visitor")
//public class VisitorController {
//
//    private VisitorService visitorService;
//
//    @Autowired
//    public VisitorController(final VisitorService visitorService) {
//        this.visitorService = visitorService;
//    }
//
//    @RequestMapping(value = "/visitorStatistic", method = RequestMethod.GET)
//    public String showAllVisitors(Model model, HttpServletResponse response) {
//        model.addAttribute("visitorList", visitorService.getAllVisitors());
//        response.setHeader("Content-Type","text/html");
//        return "visitorStatistic";
////        return "visitorStatistic";
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ResponseEntity createVisitor(
//            @RequestParam("name") final String name,
//            @RequestParam("humanCategory") final String humanCategory) {
//        visitorService.saveVisitor(name, humanCategory);
////        return "/visitorStatistic/create";
//        return new ResponseEntity("Successfully created visitor", HttpStatus.OK);
//    }
//
//}
//
