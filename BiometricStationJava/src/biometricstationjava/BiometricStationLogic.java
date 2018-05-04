/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricstationjava;

import javaserialportcomm.*;


/**
 *
 * @author jelle
 */
public class BiometricStationLogic {

    ArduinoParser parser;
    SensorData parsedData;
    SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);
//TODO: constructor
    receiver.setLineListener ( 
        new SerialPortLineListener() {
            @Override
        public void serialLineEvent
        (SerialData data
        
            ) {
                System.out.println("Received data from the serial port: " + data.getDataAsString());
            //TODO: parse the string in different sections temp, heartbeat, pulse
            parsedData = parser.parse(data.getDataAsString());

        }
    }

);
    
}
