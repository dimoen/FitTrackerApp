package com.example.myapplication;


import static android.content.ContentValues.TAG;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataManager {
    private static final DataManager dm = new DataManager();

    private List<Übung> exercises_List ;
    private List<Workout> workouts_List;
    JsonIO io = new JsonIO();


    public List<Übung> getExercises_List(){
        return this.exercises_List;
    }

    public List<Workout> getWorkouts_List(){
        return this.workouts_List;
    }


    private DataManager() {
        exercises_List = new ArrayList<Übung>(); // Initialisiere die exercises-Liste
        //loadExercises();
        try {
            io.saveWeight(5.3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            io.getWeight();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static DataManager getInstance(){
        return dm;
    }



    public void saveAll(){
        Log.d(TAG, "saveAll successfully.");

        try {
            io.dumpExercises(exercises_List);
            //io.saveWeight();
            //io.dumpWorkouts(workouts_List);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void addExercise(Übung exerciseNew) {
        boolean exerciseExists = false;

        // Iterate over the existing exercises to check if an exercise with the same name exists
        for (Übung exercise : exercises_List) {
            if (exercise.getName().equals(exerciseNew.getName())) {
                exerciseExists = true;
                break;
            }
        }

        if (exerciseExists) {
            Log.d(TAG, "Exercise with the name '" + exerciseNew.getName() + "' already exists.");
        } else {
            exercises_List.add(exerciseNew);
            Log.d(TAG, "Exercise added successfully.");

            // Save the exercises to the JSON file
            saveAll();

        }
    }

    //!!
    public void addWorkout(Workout WorkoutNew) {
        boolean exerciseExists = false;

        // Iterate over the existing exercises to check if an exercise with the same name exists
        for (Übung exercise : exercises_List) {
            if (exercise.getName().equals(WorkoutNew.getName())) {
                exerciseExists = true;
                break;
            }
        }

        if (exerciseExists) {
            Log.d(TAG, "Exercise with the name '" + WorkoutNew.getName() + "' already exists.");
        } else {
            workouts_List.add(WorkoutNew);
            Log.d(TAG, "Exercise added successfully.");

            // Save the exercises to the JSON file
            saveAll();
        }
    }

}
