package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.AnimalZone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalZoneDao  extends CrudRepository<AnimalZone, Long> {
    //@Query("select c from animalzone c where c.zone = :zoneName")
    //List<AnimalZone> findByCategory(@Param("zoneName") String zoneName);
}
