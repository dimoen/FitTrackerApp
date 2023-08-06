package com.example.myapplication;

import android.util.Log;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

class DataPoint{
    double[] aList = new double[6];
    Timestamp timestamp;
    //Timestamp timestamp = new Timestamp(System.currentTimeMillis());

}

public class Übung {

    private String name;
    private String[] attribut;
    private String[] einheit;

    List<DataPoint> dataPoints=new ArrayList<DataPoint>();

    public Übung() {
        attribut = new String[6];
        einheit = new String[6];
    }

    // Getter und Setter für "name"
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter und Setter für das Array "attribut"
    public String[] getAttribut() {
        return attribut;
    }

    public void setAttribut(String[] attribut) {
        this.attribut = attribut;
    }

    // Getter und Setter für das Array "einheit"
    public String[] getEinheit() {
        return einheit;
    }

    public void setEinheit(String[] einheit) {
        this.einheit = einheit;
    }

    public void addDataPoint(double a0, double a1, double a2, double a3, double a4, double a5, Timestamp t){
        DataPoint d = new DataPoint();
        d.aList[0] = a0;
        d.aList[1] = a1;
        d.aList[2] = a2;
        d.aList[3] = a3;
        d.aList[4] = a4;
        d.aList[5] = a5;
        d.timestamp = t;

        dataPoints.add(d);
    }

    public void print(){
        Log.i("MENU_DRAWER_TAG", "Name: " + this.name);

        for(int i = 0; i<6; i++){
            Log.i("MENU_DRAWER_TAG", "Attribut" + i + ": " + this.attribut[0] + " Einheit: " + einheit[i]);
        }

        for(DataPoint d: dataPoints){
            Log.i("MENU_DRAWER_TAG", "Time: " + d.timestamp);
            for(int i = 0; i< 6; i++){
                Log.i("MENU_DRAWER_TAG", String.valueOf(d.aList[i]));
            }
        }
    }
}
