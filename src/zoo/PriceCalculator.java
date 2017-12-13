package zoo;

public class PriceCalculator implements PriceCalculationService{

    public static double totalPrice;

    @Override
    public void calculateBasePrice(String zone) {

            if(zone.equals("General")){
                this.totalPrice = 10.00;
            }else if(zone.equals("Reptile house")){
                this.totalPrice = 20.00;
            }
                else if(zone.equals("Butterfly")){
                this.totalPrice = 15.00;
            }
                    else if(zone.equals("Insect")){
                this.totalPrice = 12.00;
            }
                        else if(zone.equals("Petting")){
                this.totalPrice = 30.00;
            }
    }

    @Override
    public void calculateDiscountForCategory(String category) {
        if(category.equals("Adults")){

        }else if(category.equals("School age children")){
            this.totalPrice = totalPrice*0.20;
        }else if(category.equals("Seniors")){
            this.totalPrice = totalPrice*0.40;
        }else if(category.equals("Students")){
            this.totalPrice = totalPrice*0.15;
        }else if(category.equals("Persons with a disability")){
            this.totalPrice = totalPrice*0.70;
        }
    }

    @Override
    public void calculatePriceWithVoucher(Voucher voucher) {
        totalPrice = totalPrice*voucher.getGeneralDiscounts().getDiscount();
    }

    @Override
    public double calculateTotalPriceWithoutVoucher(Visitor visitor, String animalZone) {
       calculateBasePrice(animalZone);
       calculateDiscountForCategory(visitor.getCatergory());
       return totalPrice;
    }

    @Override
    public double calculateTotalPriceWithVoucher(Visitor visitor, String animalZone, Voucher voucher) {
        calculateBasePrice(animalZone);
        calculateDiscountForCategory(visitor.getCatergory());
        calculatePriceWithVoucher(voucher);
        return totalPrice;
    }
}
