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
    int heartbeat = 0;
    double tempData = 0.0;
    double acc_X = 0.0;
    double acc_Y = 0.0;
    double acc_Z = 0.0;
    
    
   public SensorData parse(String dataString) {
        if (!isValidString(dataString)) {
            return null;
        }
        
        //parsen en waarden toevoegen aan nieuwe variabelen + dan een sensordata object returnen. 
        //TODO:de volledige string parsen in de verschillende waarden die worden meegegeven in de variabelen
       

        //channel = Double.parseString(dataString.substring(dataString.indexOf(BEGINSIGN) + 1, dataString.indexOf(SEPERATOR)));
        data = Integer.parseInt(dataString.substring(dataString.indexOf(BEGINSIGN) + 1, dataString.indexOf(SEPERATOR)));

        return new SensorData(tempData, heartbeat, acc_X, acc_Y, acc_Z);
    }
   
    public boolean isValidString(String dataString) {
        return (dataString.indexOf("[") != -1
                && dataString.indexOf("]") != -1
                && dataString.indexOf("|") != -1); //er moeten haken enzo aanwezig zijn anders kan hij niet parsen
    }
    

}
