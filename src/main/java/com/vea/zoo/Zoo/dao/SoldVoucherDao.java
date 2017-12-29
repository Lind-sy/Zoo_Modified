package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.SoldVouchers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldVoucherDao  extends CrudRepository<SoldVouchers, Long> {
}
