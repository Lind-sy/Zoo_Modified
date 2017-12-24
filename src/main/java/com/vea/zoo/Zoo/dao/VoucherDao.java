package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherDao extends CrudRepository<Voucher, Long> {

}
