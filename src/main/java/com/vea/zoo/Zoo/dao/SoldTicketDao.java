package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.SoldTickets;
import com.vea.zoo.Zoo.Model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoldTicketDao  extends CrudRepository<SoldTickets, Long> {

    @Query("SELECT t FROM SoldTickets t WHERE t.zooTicket.status = true")
    List<SoldTickets> findAllActiveTickets();

    @Query("select s from SoldTickets s where s.zooSoldTicketVisitor.id =:visitorId")
    List<SoldTickets> findByVisitorId(@Param("visitorId") Long visitorId);
}
