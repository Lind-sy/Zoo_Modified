package com.vea.zoo.Zoo;

import javax.persistence.*;

@Entity
@Table(name = "SOLDVOUCHERS")
public class SoldVouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor", nullable = false)
    private Visitor visitor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher", nullable = false)
    private Voucher voucher;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
