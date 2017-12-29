package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.AnimalZone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalZoneDao  extends CrudRepository<AnimalZone, Long> {

}
