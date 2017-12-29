package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.AnimalZone;
import com.vea.zoo.Zoo.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalZoneDao  extends CrudRepository<AnimalZone, Long> {
   // List<AnimalZone> findAll();
}
