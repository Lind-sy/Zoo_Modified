package com.vea.zoo.Zoo.Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "VOUCHER")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucherGeneralDiscounts", nullable = false)
    private GeneralDiscounts voucherGeneralDiscounts;

    @Column(name = "CODE")
    private String code;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "zooVoucher")
    private Set<SoldVouchers> soldVouchers = new HashSet<>();

    public Voucher() {
        this.code = genCode();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

     /**
     * Method that generates voucher code form random letters and numbers
     * @return voucher code
     */
    private String genCode() {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 10;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeneralDiscounts getVoucherGeneralDiscounts() {
        return voucherGeneralDiscounts;
    }

    public void setVoucherGeneralDiscounts(GeneralDiscounts voucherGeneralDiscounts) {
        this.voucherGeneralDiscounts = voucherGeneralDiscounts;
    }

    public Set<SoldVouchers> getSoldVouchers() {
        return soldVouchers;
    }

    public void setSoldVouchers(Set<SoldVouchers> soldVouchers) {
        this.soldVouchers = soldVouchers;
    }
}
