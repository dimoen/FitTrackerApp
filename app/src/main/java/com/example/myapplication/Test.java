package com.example.myapplication;

import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public void testit() throws FileNotFoundException {
        List<Übung> exerciseList=new ArrayList<Übung>();
        JsonIO io = new JsonIO();

        Übung u = new Übung();
        u.setName("Laufen");
        String[] aList = new String[6];
        aList[0] = "Strecke";
        aList[1] = "Dauer";
        String[] eList = new String[6];
        eList[0] = "Distance";
        eList[1] = "Time";

        u.setAttribut(aList);
        u.setEinheit(eList);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        u.addDataPoint(10, 44, 0,0,0,0,timestamp);
        u.addDataPoint(12, 53, 0,0,0,0, timestamp);
        u.addDataPoint(12.6, 55,0,0,0,0, timestamp);

        Übung t = new Übung();
        t.setName("Test");
        String[] taList = new String[6];
        taList[0] = "Strecke";
        taList[1] = "Dauer";
        String[] teList = new String[6];
        teList[0] = "Distance";
        teList[1] = "Time";

        t.setAttribut(taList);
        t.setEinheit(teList);

        t.addDataPoint(11, 47, 0,0,0,0, timestamp);
        t.addDataPoint(13, 57, 0,0,0,0, timestamp);
        t.addDataPoint(14.6, 57,0,0,0,0, timestamp);

        exerciseList.add(u);
        exerciseList.add(t);

        try {
            io.dumpExercises(exerciseList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<Übung> rexerciseList=new ArrayList<Übung>();

        try {
            rexerciseList = io.readExercises();
            Log.i("MENU_DRAWER_TAG", t.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Übung z:rexerciseList){
            z.print();
        }

        List<Workout> workoutList=new ArrayList<Workout>();

        Workout workout = new Workout();
        Übung[] wList = new Übung[6];
        wList[0] = t;
        wList[3] = u;

        workout.setName("Mein Erstes Workout");
        workout.setExercises(wList);

        workoutList.add(workout);

        try {
            io.dumpWorkouts(workoutList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Workout> rworkoutList = new ArrayList<Workout>();
        try {
            rworkoutList = io.readWorkouts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Workout> newWorkoutList = new ArrayList<Workout>();
        Übung[] cUbList = new Übung[6];
        for(Workout w:rworkoutList){
            for(Übung ub: rexerciseList){
                for(int i = 0; i<6; i++) {
                    if(w.getExercises()[i].getName().equals("Null")){
                        continue;
                    }else if(w.getExercises()[i].getName().equals(ub.getName())){
                        Log.i("MENU_DRAWER_TAG", w.getExercises()[i].getName() + " == " + ub.getName());
                        cUbList[i] = ub;
                        //cUbList[i].print();
                    }
                }
            }
            w.setExercises(cUbList);
            Arrays.fill(cUbList, null);
        }

        double weight = 75.6;
        try {
            io.saveWeight(weight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        double rweight = 0;
        try {
            rweight = io.getWeight();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Log.i("MENU_DRAWER_TAG", String.valueOf(rweight));
    }
}
