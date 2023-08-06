package com.example.myapplication;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import android.os.Environment;



public class ExerciseDataManager {
    private static final String FILE_NAME = "exercise_data.txt";
    private static final String TAG = ExerciseDataManager.class.getSimpleName();
    private List<Exercise> exercises ;

    public ExerciseDataManager() {
        exercises = new ArrayList<Exercise>(); // Initialisiere die exercises-Liste
        //loadExercises();
    }

    private List<Exercise> loadExercises() {
        // Load exercises from the JSON file and return the list
        // Implementation omitted for brevity
        return null;
    }

    private void saveExercises() {
        // Save exercises to the JSON file !!
        JSONArray jsonArray = new JSONArray();


        try {

            for (Exercise exercise : exercises) {
                JSONObject jsonExercise = new JSONObject();
                jsonExercise.put("name", exercise.getName());
                // Füge die anderen Eigenschaften hinzu
                String[] attributes = exercise.getAttribute();
                for (int i = 0; i < attributes.length; i++) {
                    jsonExercise.put("attribute" + (i + 1), attributes[i]);
                }
                jsonArray.put(jsonExercise);
            }

            // Speichere das JSON-Array in der Datei
            File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(downloadsDir, "/" +FILE_NAME);

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(jsonArray.toString().getBytes());
            fileOutputStream.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public void addExercise(Exercise exerciseNew) {
        boolean exerciseExists = false;

        // Iterate over the existing exercises to check if an exercise with the same name exists
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(exerciseNew.getName())) {
                exerciseExists = true;
                break;
            }
        }

        if (exerciseExists) {
            Log.d(TAG, "Exercise with the name '" + exerciseNew.getName() + "' already exists.");
        } else {
            exercises.add(exerciseNew);
            Log.d(TAG, "Exercise added successfully.");

            // Save the exercises to the JSON file
            saveExercises();
        }
    }

}
