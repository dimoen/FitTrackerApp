package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends NavMenu implements AdapterView.OnItemSelectedListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.settings, constraintLayout);

        // Retrieve EditText fields
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAlter = findViewById(R.id.editTextAlter);
        EditText editTextGewicht = findViewById(R.id.editTextGewicht);
        EditText editTextHoehe = findViewById(R.id.editTextHöhe);

        // Apply Changes button click listener
        Button applyButton = findViewById(R.id.searchButton);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the updated values from the EditText fields
                String updatedName = editTextName.getText().toString();
                String updatedAlter = editTextAlter.getText().toString();
                String updatedGewicht = editTextGewicht.getText().toString();
                String updatedHoehe = editTextHoehe.getText().toString();

                // Perform the necessary checks
                if (isDouble(updatedAlter) && isDouble(updatedGewicht) && isDouble(updatedHoehe)) {
                    // All inputs are valid doubles
                    // Update the values in shared preference or trigger desired action

                    // Example: Update the shared preferences with the updated values
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", updatedName);
                    editor.putString("alter", updatedAlter);
                    editor.putString("gewicht", updatedGewicht);
                    editor.putString("hoehe", updatedHoehe);
                    Toast.makeText(Settings.this, "Änderungen aufgenohmen. ", Toast.LENGTH_SHORT).show();

                    editor.apply();
                } else {
                    // At least one input is not a valid double
                    Toast.makeText(Settings.this, "Invalid input!.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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

