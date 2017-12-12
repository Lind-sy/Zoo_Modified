package zoo;

public interface PriceCalculationService {
    public void calculateBasePrice(String zone);
    public void calculateDiscountForCategory(String category);
    public void calculatePriceWithVoucher(Voucher voucher);
    public double calculateTotalPriceWithoutVoucher(Visitor visitor, String animalZone);
    public double calculateTotalPriceWithVoucher(Visitor visitor, String animalZone, Voucher voucher);
}
