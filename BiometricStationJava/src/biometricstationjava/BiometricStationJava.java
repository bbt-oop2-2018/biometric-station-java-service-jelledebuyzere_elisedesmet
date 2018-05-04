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
public class BiometricStationJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);
        
        receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                System.out.println("Received data from the serial port: " + data.getDataAsString());
                
                
            }
        });
    }
    
}
