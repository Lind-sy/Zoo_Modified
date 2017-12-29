package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.SoldTickets;
import org.springframework.data.repository.CrudRepository;

public interface SoldTicketDao  extends CrudRepository<SoldTickets, Long> {
}
