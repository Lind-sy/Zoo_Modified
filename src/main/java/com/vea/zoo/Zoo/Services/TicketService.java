package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.dao.AnimalZoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private PriceCalculator priceCalculator;

    @Autowired
    public TicketService(final PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
}
