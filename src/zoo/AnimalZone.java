/**
 *
 */
package zoo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Martins Buhanovskis
 */
public class AnimalZone {

    private String zone;
    private static final Map<String, String> availableZoneList = setDefaultZoneMap();

    public Map<String, String> getAvailableZoneList() {
        return availableZoneList;
    }

    public String getZone() {
        if (!zone.isEmpty()) {
            return zone;
        } else {
            throw new IllegalArgumentException("No Zone defined");
        }
    }

    public void setZone(String zone) {
        if (availableZoneList.isEmpty()) {
            throw new IllegalStateException("Zones are not defined!");
        } else if (availableZoneList.containsKey(zone)) {
            this.zone = zone;
        } else if (!availableZoneList.containsKey(zone)) {
            throw new IllegalArgumentException("Such Zone does not exist");
        }
    }

    AnimalZone() {
    }

    /**
     * Method that defines default animal zones available for visitor
     * @return Map of Zoo animalZones
     */
    private static Map<String, String> setDefaultZoneMap() {
        Map<String, String> animalZoneMap1 = new HashMap<String, String>();
        animalZoneMap1.put("General", "name");
        animalZoneMap1.put("Reptile house", "name");
        animalZoneMap1.put("Butterfly", "name");
        animalZoneMap1.put("Insect", "name");
        animalZoneMap1.put("Petting", "name");
        return animalZoneMap1;
    }
}
