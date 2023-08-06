package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class WorkoutTracken extends NavMenu implements AdapterView.OnItemSelectedListener{

    private Spinner spinner_workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_workout_tracken,constraintLayout);

        ArrayAdapter<CharSequence> adapter_workouts = ArrayAdapter.createFromResource(this, R.array.workouts, android.R.layout.simple_spinner_dropdown_item);
        adapter_workouts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_workouts = findViewById(R.id.spinner13);

        spinner_workouts.setAdapter(adapter_workouts);
        spinner_workouts.setOnItemSelectedListener(this);

        navigationView.getMenu().getItem(4).setChecked(true);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}