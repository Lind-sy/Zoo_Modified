/**
 * 
 */
package zoo;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Martins Buhanovskis
 *
 */
public class GeneralDiscounts {

	private static Map<Integer,Double> discountMap = setAvailableDiscounts();
	private int discount;

	public Map<Integer, Double> getDiscountMap() {
		return discountMap;
	}

	public int getDiscount() {
		return discount;
	}

	public GeneralDiscounts(int discountType) {
		setDiscount(discountType);
	}


	public void setDiscount(int discount) {
		if (discountMap.isEmpty()) {
			throw new IllegalStateException("Discounts are not defined!");
		} else if (discountMap.containsKey(discount)) {
			this.discount = discount;
		} else if (!discountMap.containsKey(discount)) {
			throw new IllegalArgumentException("Such Discount does not exist");
		}
	}

	/**
	 * Method that defines available discounts that can be applied for ticket price
	 * @return Map of defined discounts
	 */
	public static Map<Integer, Double> setAvailableDiscounts() {
		Map<Integer, Double> discountMap =  new HashMap<>();
		discountMap.put(10,0.10);
		discountMap.put(15,0.15);
		discountMap.put(20,0.20);
		return discountMap;
	}
}
