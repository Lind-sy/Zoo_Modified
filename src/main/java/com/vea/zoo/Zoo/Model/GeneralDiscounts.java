
package com.vea.zoo.Zoo.Model;

import javax.persistence.*;

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
    private Double discount;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "voucherGeneralDiscounts")
    private Voucher zooVoucher;

    public GeneralDiscounts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Voucher getZooVoucher() {
        return zooVoucher;
    }

    public void setZooVoucher(Voucher zooVoucher) {
        this.zooVoucher = zooVoucher;
    }
}
