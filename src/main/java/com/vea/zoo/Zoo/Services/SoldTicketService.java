package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.AnimalZone;
import com.vea.zoo.Zoo.Model.SoldTickets;
import com.vea.zoo.Zoo.dao.AnimalZoneDao;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldTicketService {
    private SoldTicketDao soldTicketDao;

    @Autowired
    public SoldTicketService( final SoldTicketDao soldTicketDao) {
        this.soldTicketDao = soldTicketDao;
    }
    public List<SoldTickets> getAllSoldTickets(){
        return (List<SoldTickets>) soldTicketDao.findAll();
    }
    public List<SoldTickets> getActiveTickets(){
        return (List<SoldTickets>) soldTicketDao.findAllActiveTickets();
    }
}
