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

    private final static char BEGINSIGN = '[';
    private final static char SEPERATOR = '|';
    private final static char SECONDSEP = '&';
    private final static char THIRDSEP = 'é';
    //TODO: make more beginsigns and separators for the big string
    private final static char ENDSIGN = ']';
    int heartbeat = 0;
    double temperature = 0.0;
    double acc_X = 0.0;
    double acc_Y = 0.0;
    double acc_Z = 0.0;

    public ArduinoParser() {
    }

    public SensorData parse(String dataString) {
        System.out.println("data: " + dataString);
//        if (!isValidString(dataString)) {
//            //throw new 
//            return null;
//        }

// other solution
        //String[] data = dataString.split("|");
        temperature = Double.parseDouble(dataString.substring(dataString.indexOf(BEGINSIGN) + 1, dataString.indexOf(SEPERATOR)));
        
        //parsen en waarden toevoegen aan nieuwe variabelen + dan een sensordata object returnen. 
        //TODO:de volledige string parsen in de verschillende waarden die worden meegegeven in de variabelen
        System.out.println(temperature);

        //channel = Double.parseString(dataString.substring(dataString.indexOf(BEGINSIGN) + 1, dataString.indexOf(SEPERATOR)));
        return new SensorData(temperature, heartbeat, acc_X, acc_Y, acc_Z);
    }

    public boolean isValidString(String dataString) {
        return (dataString.indexOf("[") != -1
                && dataString.indexOf("]") != -1
                && dataString.indexOf("|") != -1); //er moeten haken enzo aanwezig zijn anders kan hij niet parsen
    }

}
