package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.GeneralDiscounts;
import com.vea.zoo.Zoo.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface GeneralDiscountDao  extends CrudRepository<GeneralDiscounts, Long> {
}
