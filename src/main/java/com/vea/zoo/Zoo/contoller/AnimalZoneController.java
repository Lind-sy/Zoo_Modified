package com.vea.zoo.Zoo.contoller;

import com.vea.zoo.Zoo.Model.AnimalZone;
import com.vea.zoo.Zoo.Services.AnimalZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalZoneController {
    private AnimalZoneService animalZoneService;

    @Autowired
    public AnimalZoneController(final AnimalZoneService animalZoneService) {
        this.animalZoneService = animalZoneService;
    }
    @RequestMapping(value = "/animalZones", method = RequestMethod.GET)
    public String animalZones(Model model) {
        model.addAttribute("animalzoneList",animalZoneService.returnAllAnimalZones());
        return "animalZones";
    }

    @RequestMapping(value = "/addAnimalZone", method = RequestMethod.GET)
    public String animalZoneAddForm(Model model) {
        model.addAttribute("animalzone", new AnimalZone());
        return "addAnimalZone";
    }
    @RequestMapping(value = "/createAnimalZone", method = RequestMethod.POST)
    public String createAnimalZone(@RequestParam("zone") final String zoneName){
        animalZoneService.createAnimalZone(zoneName);
        return "animalZones";
    }
}
