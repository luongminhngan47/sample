
package Country_69loc;

import java.util.Scanner;
public class EastAsiaCountries extends Country { //ke thua
    private String countryTerrain;

    public EastAsiaCountries() {
        
    }
    public EastAsiaCountries(String countryCode, String countryName, double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString() {
        String out = String.format("%-20s%-20s%-20f%-20s", countryCode, countryName, totalArea, countryTerrain);
        return out;
    }
    
}
