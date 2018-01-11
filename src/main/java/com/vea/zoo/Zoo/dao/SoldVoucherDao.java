package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.SoldVouchers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoldVoucherDao  extends CrudRepository<SoldVouchers, Long> {

    @Query("select s from SoldVouchers s where s.zooVisitorOwner.id =:visitorId")
    List<SoldVouchers> findByVisitorId(@Param("visitorId") Long visitorId);
}
