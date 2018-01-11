/**
 * 
 */
package com.vea.zoo.Zoo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@OneToMany(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL,
			mappedBy = "visitorHumanCategory")
	private Set<Visitor> zooHumanCategoryVisitor = new HashSet<>();

	public HumanCatorgorys() {

	}

	public Set<Visitor> getZooHumanCategoryVisitor() {
		return zooHumanCategoryVisitor;
	}

	public void setZooHumanCategoryVisitor(Set<Visitor> zooHumanCategoryVisitor) {
		this.zooHumanCategoryVisitor = zooHumanCategoryVisitor;
	}

	public Long getId() {
		return id;
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
