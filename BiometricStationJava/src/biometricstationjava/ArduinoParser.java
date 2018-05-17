/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricstationjava;

/**
 *
 * @author Jelle
 */
public class ArduinoParser {

    static final int ARRAYSIZE = 5;
    private int heartbeat = 0;
    private double temperature = 0.0;
    private double acc_X = 0.0;
    private double acc_Y = 0.0;
    private double acc_Z = 0.0;

    public ArduinoParser() {
    }

    public SensorData parse(String dataString) {
        String[] data = dataString.split(";");
        if (!isValidStringArray(data)) {
            System.out.println("check data, something wrong has happened!");
            return null;
        }

        temperature = Double.parseDouble(data[0]);
        heartbeat = Integer.parseInt(data[1]);
        acc_X = Double.parseDouble(data[2]);
        acc_Y = Double.parseDouble(data[3]);
        acc_Z = Double.parseDouble(data[4]);

        return new SensorData(temperature, heartbeat, acc_X, acc_Y, acc_Z);
    }

    public boolean isValidStringArray(String[] data) {
        boolean valid = true;
        for (int i = 0; i < data.length && valid == true; i++) {
            if (data[i].isEmpty()) {
                valid = false;
            }
        }
        return valid && data.length == ARRAYSIZE; //Krijgt niet altijd de juiste data door.
    }
}
