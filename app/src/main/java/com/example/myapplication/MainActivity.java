package com.example.myapplication;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends NavMenu {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main, constraintLayout);

        // Retrieve values from shared preference
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String alter = sharedPreferences.getString("alter", "");
        String gewicht = sharedPreferences.getString("gewicht", "");
        String hoehe = sharedPreferences.getString("hoehe", "");

        // Display the values in TextViews
        TextView textName = findViewById(R.id.textName);
        TextView textAlter = findViewById(R.id.textAlter);
        TextView textGewicht = findViewById(R.id.textGewicht);
        TextView textHoehe = findViewById(R.id.textHeight);

        textName.setText("Name: " + name);
        textAlter.setText("Alter: " + alter);
        textGewicht.setText("Gewicht: " + gewicht);
        textHoehe.setText("Höhe: " + hoehe);
    }

    // Rest of the code...
}
