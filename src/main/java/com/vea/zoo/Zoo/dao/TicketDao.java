package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Long>{

    @Query("select c from Ticket c ORDER BY id desc")
    List<Ticket> findAllSorted();

}
