/**
 *
 */
package com.vea.zoo.Zoo.Model;

import javax.persistence.*;

/**
 * @author Martins Buhanovskis
 */
@Entity
@Table(name = "ANIMALZONE")
public class AnimalZone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ZONE")
    private String zone;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "ticketAnimalZone")
    private Ticket zooTicket;

    public AnimalZone(String zone) {
        this.zone = zone;
    }

    public AnimalZone() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Ticket getZooTicket() {
        return zooTicket;
    }

    public void setZooTicket(Ticket zooTicket) {
        this.zooTicket = zooTicket;
    }
}
