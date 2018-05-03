/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricstationjava;

import javaserialportcomm.*;
import mqttservice.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jelle
 */
public class BiometricStationJavaFunctionality extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);
        
         receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                System.out.println("Received data from the serial port: " + data.getDataAsString());
                Service service = new Service();
                service.sendMessage(data.getDataAsString());
            }
        });
        
        
    }
    
}
