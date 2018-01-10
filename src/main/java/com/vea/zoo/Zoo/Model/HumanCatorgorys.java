/**
 * 
 */
package com.vea.zoo.Zoo.Model;

import javax.persistence.*;

/**
 * @author Martins Buhanovskis
 *
 */
@Entity
@Table(name = "HUMANCATORGORYS")
public class HumanCatorgorys {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CATEGORY")
	private String category;

	@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL,
			mappedBy = "visitorHumanCategory")
	private Visitor zooHumanCategoryVisitor;

	public HumanCatorgorys() {

	}

	public Long getId() {
		return id;
	}

	public Visitor getZooHumanCategoryVisitor() {
		return zooHumanCategoryVisitor;
	}

	public void setZooHumanCategoryVisitor(Visitor zooHumanCategoryVisitor) {
		this.zooHumanCategoryVisitor = zooHumanCategoryVisitor;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
