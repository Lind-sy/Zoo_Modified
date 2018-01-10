package com.vea.zoo.Zoo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Martins Buhanovskis
 * 
 * Visitor class. 
 * 
 * 		Visitor:
 * 				* gets or gives ticket
 * 				* gives ticket
 *
 */
@Entity
@Table(name = "VISITOR")
public class Visitor{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visitorHumanCategory", nullable = false)
	private HumanCatorgorys visitorHumanCategory;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "zooSoldTicketVisitor")
	private Set<SoldTickets> soldTickets = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "zooVisitorOwner")
	private Set<SoldVouchers> soldVouchers = new HashSet<>();

	public Visitor(String name){
		this.name = name;
	}

	public Visitor(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Visitor(String name, HumanCatorgorys visitorHumanCategory){
		this.name = name;
		this.visitorHumanCategory = visitorHumanCategory;
	}

	public HumanCatorgorys getVisitorHumanCategory() {
		return visitorHumanCategory;
	}

	public void setVisitorHumanCategory(HumanCatorgorys visitorHumanCategory) {
		this.visitorHumanCategory = visitorHumanCategory;
	}

	public Set<SoldTickets> getSoldTickets() {
		return soldTickets;
	}

	public void setSoldTickets(Set<SoldTickets> soldTickets) {
		this.soldTickets = soldTickets;
	}

	public Set<SoldVouchers> getSoldVouchers() {
		return soldVouchers;
	}

	public void setSoldVouchers(Set<SoldVouchers> soldVouchers) {
		this.soldVouchers = soldVouchers;
	}
}
