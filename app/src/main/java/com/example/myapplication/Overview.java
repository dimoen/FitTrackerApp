package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import java.util.List;

public class Overview extends NavMenu implements AdapterView.OnItemSelectedListener {
    private Button exercisesButton;
    private Button workoutsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.overview, constraintLayout);

        exercisesButton = findViewById(R.id.exercisesButton);
        workoutsButton = findViewById(R.id.workoutsButton);

        exercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayExerciseNames();
            }
        });

        workoutsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayWorkoutNames();
            }
        });
    }

    private void displayExerciseNames() {
        // Get the exercise names from the DataManager
        List<Übung> exercisesList = DataManager.getInstance().getExercises_List();

        StringBuilder sb = new StringBuilder();
        for (Übung exercise : exercisesList) {
            sb.append(exercise.getName()).append("\n");
        }

        // Show the exercise names in a pop-up window (AlertDialog)
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exercise Names");
        builder.setMessage(sb.toString());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void displayWorkoutNames() {
        // Get the workout names from the DataManager
        List<Workout> workoutsList = DataManager.getInstance().getWorkouts_List();

        StringBuilder sb = new StringBuilder();
        for (Workout workout : workoutsList) {
            sb.append(workout.getName()).append("\n");
        }

        // Show the workout names in a pop-up window (AlertDialog)
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Workout Names");
        builder.setMessage(sb.toString());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Implement your logic for item selection
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Implement your logic for no item selected
    }
}

