package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.AnimalZone;
import com.vea.zoo.Zoo.dao.AnimalZoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalZoneService{

    private AnimalZoneDao animalZoneDao;

    @Autowired
    public AnimalZoneService( final AnimalZoneDao animalZoneDao) {
        this.animalZoneDao = animalZoneDao;
    }

    public  List<AnimalZone> getAnimalZones(){
       return (List<AnimalZone>) animalZoneDao.findAll();
    }

    public void createAnimalZone(String zoneName){
        final AnimalZone animalZone = new AnimalZone(zoneName);
        animalZoneDao.save(animalZone);
    }
}
