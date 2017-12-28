/**
 *
 */
package com.vea.zoo.Zoo;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Martins Buhanovskis
 */
@Entity
@Table(name = "GENERALDISCOUNTS")
public class GeneralDiscounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DISCOUNT")
    private int discount;

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "voucher")
    private Voucher voucher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


//	private static Map<Integer,Double> discountMap = setAvailableDiscounts();
//
//	public Map<Integer, Double> getDiscountMap() {
//		return discountMap;
//	}
//
//	public int getDiscount() {
//		return discount;
//	}
//
//	public GeneralDiscounts(int discountType) {
//		setDiscount(discountType);
//	}
//
//
//	public void setDiscount(int discount) {
//		if (discountMap.isEmpty()) {
//			throw new IllegalStateException("Discounts are not defined!");
//		} else if (discountMap.containsKey(discount)) {
//			this.discount = discount;
//		} else if (!discountMap.containsKey(discount)) {
//			throw new IllegalArgumentException("Such Discount does not exist");
//		}
//	}
//
//	/**
//	 * Method that defines available discounts that can be applied for ticket price
//	 * @return Map of defined discounts
//	 */
//	public static Map<Integer, Double> setAvailableDiscounts() {
//		Map<Integer, Double> discountMap =  new HashMap<>();
//		discountMap.put(10,0.10);
//		discountMap.put(15,0.15);
//		discountMap.put(20,0.20);
//		return discountMap;
//	}
}
