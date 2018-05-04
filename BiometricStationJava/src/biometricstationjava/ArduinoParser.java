/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricstationjava;

/**
 *
 * @author jelle
 */
public class ArduinoParser { //als data uit arduino komt, dan beginnen we met parsen

    private final static String BEGINSIGN = "[";
    private final static String ENDSIGN = "]";
    private final static String SEPERATOR = "|";
    double data = 0;
    
   public SensorData parseTemp(String dataString) {
        if (!isValidString(dataString)) {
            return null;
        }
        
        //parsen en waarden toevoegen aan nieuwe variabelen + dan een sensordata object returnen.
       

        //channel = Double.parseString(dataString.substring(dataString.indexOf(BEGINSIGN) + 1, dataString.indexOf(SEPERATOR)));
        data = Integer.parseInt(dataString.substring(dataString.indexOf(BEGINSIGN) + 1, dataString.indexOf(SEPERATOR)));

        return new SensorData(data);
    }
   
   public SensorData parseAccelero(String dataString) {
       if (!isValidString(dataString)) {
            return null;
        }
       data= 0.0;
       return new SensorData(data);
     }
    public boolean isValidString(String dataString) {
        return (dataString.indexOf("[") != -1
                && dataString.indexOf("]") != -1
                && dataString.indexOf("|") != -1); //er moeten haken enzo aanwezig zijn anders kan hij niet parsen
    }
    

}
