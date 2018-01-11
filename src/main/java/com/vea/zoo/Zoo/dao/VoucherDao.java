package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.Voucher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherDao extends CrudRepository<Voucher, Long> {
    @Query("select s from Voucher s where s.code =:code")
    List<Voucher> findByCode(@Param("code") String code);

}
