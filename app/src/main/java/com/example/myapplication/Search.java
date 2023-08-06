package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Search extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DataManager dataManager = DataManager.getInstance();

    private RadioGroup filterRadioGroup;
    private EditText searchEditText;
    private Button searchButton;

    private static final String TAG = "SearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_search);

        filterRadioGroup = findViewById(R.id.filterRadioGroup);
        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Handle item selection if needed
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Handle empty selection if needed
    }

    private void searchExercises(String keyword) {
        List<Übung> exercisesList = dataManager.getExercises_List();
        for (Übung exercise : exercisesList) {
            if (exercise.getName().equalsIgnoreCase(keyword)) {
                // Perform desired action when the exercise is found
                // For example, display the exercise details or navigate to another activity
                Toast.makeText(this, "Exercise found: " + exercise.getName(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Exercise found: " + exercise.getName());
                showExerciseDetails(exercise);
                return;
            }
        }
        Toast.makeText(this, "Exercise not found", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Exercise not found");
    }

    private void searchWorkouts(String keyword) {
        List<Workout> workoutsList = dataManager.getWorkouts_List();
        for (Workout workout : workoutsList) {
            if (workout.getName().equalsIgnoreCase(keyword)) {
                // Perform desired action when the workout is found
                // For example, display the workout details or navigate to another activity
                Toast.makeText(this, "Workout found: " + workout.getName(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Workout found: " + workout.getName());
                showWorkoutDetails(workout);
                return;
            }
        }
        Toast.makeText(this, "Workout not found", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Workout not found");
    }

    private void performSearch() {
        int selectedRadioButtonId = filterRadioGroup.getCheckedRadioButtonId();
        String searchKeyword = searchEditText.getText().toString().trim();

        if (selectedRadioButtonId == R.id.exercisesRadioButton) {
            searchExercises(searchKeyword);
        } else if (selectedRadioButtonId == R.id.workoutsRadioButton) {
            searchWorkouts(searchKeyword);
        }
    }

    private void showExerciseDetails(Übung exercise) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(exercise.getName());

        StringBuilder messageBuilder = new StringBuilder();
        String[] attributes = exercise.getAttribut();
        String[] units = exercise.getEinheit();

        for (int i = 0; i < attributes.length; i++) {
            int attributeNumber = i + 1;
            String attributeValue = attributes[i];
            String unit = units[i];

            if (!attributeValue.isEmpty()) {
                messageBuilder.append("Attribute ").append(attributeNumber).append(": ").append(attributeValue).append(" ").append(unit).append("\n");
            }
        }

        builder.setMessage(messageBuilder.toString());
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void showWorkoutDetails(Workout workout) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(workout.getName());

        StringBuilder messageBuilder = new StringBuilder();

        Übung[] exercises = workout.getExercises();
        for (int i = 0; i < exercises.length; i++) {
            Übung exercise = exercises[i];
            messageBuilder.append("Exercise ").append(i + 1).append(": ").append(exercise.getName()).append("\n");

            String[] attributes = exercise.getAttribut();
            for (int j = 0; j < attributes.length; j++) {
                String attributeValue = attributes[j];
                String unit = exercise.getEinheit()[j];

                if (!attributeValue.isEmpty()) {
                    messageBuilder.append("   Attribute ").append(j + 1).append(": ").append(attributeValue).append(" ").append(unit).append("\n");
                }
            }
        }

        builder.setMessage(messageBuilder.toString());
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
