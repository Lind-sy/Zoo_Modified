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

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	@Column(name = "CATEGORY")
	private String category;

	@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL,
			mappedBy = "category")
	private Visitor visitor;

	//private static final Map<String, String> categoryMap = defaultHumanCategoryMap();

	public HumanCatorgorys() {

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

//	public String getCategory() {
//		if(!category.isEmpty()) {
//			return category;
//		}else{
//			throw new IllegalArgumentException("No Category defined");
//		}
//	}
//
//	public void setCategory(String category) {
//		if(categoryMap.isEmpty()){
//			throw new IllegalStateException("Categorys are not defined!");
//		}else if(categoryMap.containsKey(category)){
//			this.category = category;
//		}else if(!categoryMap.containsKey(category)){
//			throw new IllegalArgumentException("Such category does not exist");
//		}
//	}
//
//	public Map<String, String> getCategoryMap() {
//		return categoryMap;
//	}
//
//	/**
//	 * Method that defines available human statuses
//	 * @return Map of human categories
//	 */
//	private static Map<String, String> defaultHumanCategoryMap() {
//        Map<String, String> statusMap1 = new HashMap<String, String>();
//        statusMap1.put("Adult","name");
//		statusMap1.put("School age children","name");
//		statusMap1.put("Seniors","name");
//		statusMap1.put("Student","name");
//		statusMap1.put("Persons with a disability","name");
//        return statusMap1;
//   }
}
