package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.Visitor;
import com.vea.zoo.Zoo.Model.Voucher;

public interface PriceCalculationService {
    public void calculateBasePrice(String zone);
    public void calculateDiscountForCategory(String category);
    public void calculatePriceWithVoucher(Voucher voucher);
    public double calculateTotalPriceWithoutVoucher(Visitor visitor, String animalZone);
    public double calculateTotalPriceWithVoucher(Visitor visitor, String animalZone, Voucher voucher);
}
