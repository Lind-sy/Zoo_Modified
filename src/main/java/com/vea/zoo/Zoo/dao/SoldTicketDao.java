package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.SoldTickets;
import com.vea.zoo.Zoo.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface SoldTicketDao  extends CrudRepository<SoldTickets, Long> {
}
