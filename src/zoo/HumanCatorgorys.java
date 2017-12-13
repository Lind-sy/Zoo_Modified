/**
 * 
 */
package zoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Martins Buhanovskis
 *
 */
public class HumanCatorgorys {
	
	private String category;
	private static final Map<String, String> categoryMap = defaultHumanCategoryMap();

	public HumanCatorgorys() {

	}

	public String getCategory() {
		if(!category.isEmpty()) {
			return category;
		}else{
			throw new IllegalArgumentException("No Category defined");
		}
	}

	public void setCategory(String category) {
		if(categoryMap.isEmpty()){
			throw new IllegalStateException("Categorys are not defined!");
		}else if(categoryMap.containsKey(category)){
			this.category = category;
		}else if(!categoryMap.containsKey(category)){
			throw new IllegalArgumentException("Such category does not exist");
		}
	}

	public Map<String, String> getCategoryMap() {
		return categoryMap;
	}

	/**
	 * Method that defines available human statuses
	 * @return Map of human categories
	 */
	private static Map<String, String> defaultHumanCategoryMap() {
        Map<String, String> statusMap1 = new HashMap<String, String>();
        statusMap1.put("Adult","name");
		statusMap1.put("School age children","name");
		statusMap1.put("Seniors","name");
		statusMap1.put("Student","name");
		statusMap1.put("Persons with a disability","name");
        return statusMap1;
   }
}
