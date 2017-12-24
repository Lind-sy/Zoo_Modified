package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Ticket;
import com.vea.zoo.Zoo.dao.TicketDao;
import com.vea.zoo.Zoo.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {
    @Autowired
    private VisitorDao visitorDao;

    @RequestMapping(value = "/newVisitoer", method = RequestMethod.POST)
    public ResponseEntity addTicket(@RequestParam("category") final String category,
                                    @RequestParam("name") final String name) {
      //  visitorDao.save(new Visitoer(zone, price));
        return new ResponseEntity(HttpStatus.OK);
    }
}
