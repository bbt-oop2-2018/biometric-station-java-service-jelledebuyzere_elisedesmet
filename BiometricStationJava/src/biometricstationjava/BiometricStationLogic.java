/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricstationjava;

import javaserialportcomm.*;
import mqttservice.*;

/**
 *
 * @author jelle
 */
public class BiometricStationLogic {

    SerialData data; //zo?
    ArduinoParser parser;
    SensorData parsedData;
    Service service;
    
    SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);

    public BiometricStationLogic() {
        parser = new ArduinoParser();
        //service = new Service("Jelle", "Temperature");
         receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                    parsedData = parser.parse(data.getDataAsString()); 
                    System.out.println("Received data from the serial port: " + parsedData.toString());
                   //hoe kan ik dit testen?
            }
        });
    }
}
