package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends CrudRepository<Ticket, Long>{



}
