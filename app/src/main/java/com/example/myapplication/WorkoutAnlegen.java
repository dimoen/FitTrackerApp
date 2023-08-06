package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class WorkoutAnlegen extends NavMenu implements AdapterView.OnItemSelectedListener{

    private Spinner spinner_uebungen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_workout_anlegen);
        getLayoutInflater().inflate(R.layout.activity_workout_anlegen,constraintLayout);

        ArrayAdapter<CharSequence> adapter_uebungen = ArrayAdapter.createFromResource(this, R.array.uebungen, android.R.layout.simple_spinner_dropdown_item);
        adapter_uebungen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_uebungen = findViewById(R.id.spinner);

        spinner_uebungen.setAdapter(adapter_uebungen);
        spinner_uebungen.setOnItemSelectedListener(this);

        spinner_uebungen = findViewById(R.id.spinner7);

        spinner_uebungen.setAdapter(adapter_uebungen);
        spinner_uebungen.setOnItemSelectedListener(this);

        spinner_uebungen = findViewById(R.id.spinner8);

        spinner_uebungen.setAdapter(adapter_uebungen);
        spinner_uebungen.setOnItemSelectedListener(this);

        spinner_uebungen = findViewById(R.id.spinner9);

        spinner_uebungen.setAdapter(adapter_uebungen);
        spinner_uebungen.setOnItemSelectedListener(this);

        spinner_uebungen = findViewById(R.id.spinner10);

        spinner_uebungen.setAdapter(adapter_uebungen);
        spinner_uebungen.setOnItemSelectedListener(this);

        spinner_uebungen = findViewById(R.id.spinner11);

        spinner_uebungen.setAdapter(adapter_uebungen);
        spinner_uebungen.setOnItemSelectedListener(this);


        navigationView.getMenu().getItem(3).setChecked(true);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}