package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.GeneralDiscounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralDiscountDao  extends CrudRepository<GeneralDiscounts, Long> {
}
