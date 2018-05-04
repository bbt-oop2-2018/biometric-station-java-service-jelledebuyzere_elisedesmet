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

    SerialData data; 
    ArduinoParser parser;
    SensorData parsedData;
    Service serviceTemp = new Service("Jelle", "Temperature");

    SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);

    public BiometricStationLogic() {
        parser = new ArduinoParser();
        //service = new Service("Jelle", "Temperature");
        receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                String s = data.getDataAsString();
                System.out.println("Received data from the serial port: " + data.getDataAsString());
                
                parsedData = parser.parse(s);
                System.out.println(parsedData.toString());
                serviceTemp.sendMessage(parsedData.getTempData()+ "");
                //hoe kan ik dit testen?
            }
        });
    }
}
