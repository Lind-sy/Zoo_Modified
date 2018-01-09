package com.vea.zoo.Zoo.Model;

import javax.persistence.*;

@Entity
@Table(name = "SOLDVOUCHERS")
public class SoldVouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    public Visitor getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(Visitor visitor) {
//        this.visitor = visitor;
//    }

    public SoldVouchers() {
//        this.visitor = visitor;
    }

//    public Voucher getVoucher() {
//        return voucher;
//
//    }
//
//    public void setVoucher(Voucher voucher) {
//        this.voucher = voucher;
//    }

//    public Visitor getZooVisitor() {
//        return zooVisitor;
//    }
//
//    public void setZooVisitor(Visitor zooVisitor) {
//        this.zooVisitor = zooVisitor;
//    }

    public Voucher getZooVoucher() {
        return zooVoucher;
    }

    public void setZooVoucher(Voucher zooVoucher) {
        this.zooVoucher = zooVoucher;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooVisitorOwner", nullable = false)
    private Visitor zooVisitorOwner;

    public Visitor getZooVisitorOwner() {
        return zooVisitorOwner;
    }

    public void setZooVisitorOwner(Visitor zooVisitorOwner) {
        this.zooVisitorOwner = zooVisitorOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooVoucher", nullable = false)
    private Voucher zooVoucher;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
