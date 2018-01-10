package com.vea.zoo.Zoo.Model;

import javax.persistence.*;

@Entity
@Table(name = "SOLDVOUCHERS")
public class SoldVouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooVisitorOwner", nullable = false)
    private Visitor zooVisitorOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooVoucher", nullable = false)
    private Voucher zooVoucher;

    public SoldVouchers() {

    }

    public Visitor getZooVisitorOwner() {
        return zooVisitorOwner;
    }

    public void setZooVisitorOwner(Visitor zooVisitorOwner) {
        this.zooVisitorOwner = zooVisitorOwner;
    }

    public Voucher getZooVoucher() {
        return zooVoucher;
    }

    public void setZooVoucher(Voucher zooVoucher) {
        this.zooVoucher = zooVoucher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
