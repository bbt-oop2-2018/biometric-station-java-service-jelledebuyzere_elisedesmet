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
    Service serviceAccel = new Service("Jelle", "Accelerometer");
    Service servicePulse = new Service("Jelle", "Heartpulse");
    
    SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);
    
    public BiometricStationLogic() {
        parser = new ArduinoParser();
        receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                String s = data.getDataAsString();
                System.out.println("Received data from the serial port: " + data.getDataAsString());
                
                parsedData = parser.parse(s);
                if (parsedData != null) { //data is valid
                    System.out.println(parsedData.toString()); 
                    serviceTemp.sendMessage(parsedData.getTempData() + "");
                    servicePulse.sendMessage(parsedData.getHeartbeat() + "");
                    serviceAccel.sendMessage(parsedData.getAllAcc()); 
                    System.out.println("Data sent to broker in separate channels!");
                }
            }
        });
    }
}
