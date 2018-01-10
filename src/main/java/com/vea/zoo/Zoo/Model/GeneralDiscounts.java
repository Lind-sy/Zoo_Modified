
package com.vea.zoo.Zoo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "voucherGeneralDiscounts")
    private Set<Voucher> zooVoucher = new HashSet<>();

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

    public Set<Voucher> getZooVoucher() {
        return zooVoucher;
    }

    public void setZooVoucher(Set<Voucher> zooVoucher) {
        this.zooVoucher = zooVoucher;
    }
}
