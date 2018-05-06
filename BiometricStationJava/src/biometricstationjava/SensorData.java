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
public class SensorData {

    private double tempData;
    private int heartbeat;
    private double acc_X;
    private double acc_Y;
    private double acc_Z;

    public SensorData(double tempData, int hearbeat, double acc_X, double acc_Y, double acc_Z) {
        this.tempData = tempData;
        this.heartbeat = hearbeat;
        this.acc_X = acc_X;
        this.acc_Y = acc_Y;
        this.acc_Z = acc_Z;
    }

    public double getTempData() {
        return tempData;
    }

    public int getHeartbeat() {
        return heartbeat;
    }
    
    public String getAllAcc(){ // for sending to the broker and sending back to javafx
        return "X= " + getAcc_X() + ", Y= " + getAcc_Y() + ", Z= " + getAcc_Z();
    }

    public double getAcc_X() {
        return acc_X;
    }

    public double getAcc_Y() {
        return acc_Y;
    }

    public double getAcc_Z() {
        return acc_Z;
    }

    @Override
    public String toString() {
        return "SensorData{" + "Temperature= " + tempData + "°C, Hearbeat= " + heartbeat + "BPM, X= " + acc_X + ", Y= " + acc_Y + ", Z= " + acc_Z + '}';
    }

}
