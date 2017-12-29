package com.vea.zoo.Zoo.Model;

import com.vea.zoo.Zoo.Model.GeneralDiscounts;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "VOUCHER")
public class Voucher {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generaldiscount", nullable = false)
    private GeneralDiscounts generalDiscounts;
    @Column(name = "CODE")
    private String code;


//    public void setGeneralDiscounts(Long generalDiscounts) {
//        this.generalDiscounts = generalDiscounts;
//    }

    public GeneralDiscounts getGeneralDiscounts() {
        return generalDiscounts;
    }

    public void setGeneralDiscounts(GeneralDiscounts generalDiscounts) {
        this.generalDiscounts = generalDiscounts;
    }

    public void setCode(String code) {
        this.code = code;
    }

     public Voucher() {

    }

//    public Long getGeneralDiscounts() {
//        return generalDiscounts;
//    }

    public String getCode() {
        return code;
    }

    public Voucher(Long discountType) {
//        this.generalDiscounts = discountType;
        this.code = genCode();
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
}
