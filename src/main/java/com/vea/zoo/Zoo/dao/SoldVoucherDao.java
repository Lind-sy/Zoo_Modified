package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.SoldVouchers;
import com.vea.zoo.Zoo.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface SoldVoucherDao  extends CrudRepository<SoldVouchers, Long> {
}
