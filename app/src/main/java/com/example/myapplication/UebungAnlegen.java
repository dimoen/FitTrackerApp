package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class UebungAnlegen extends NavMenu implements AdapterView.OnItemSelectedListener {

    private Spinner spinner_einheiten;

    DataManager dm = DataManager.getInstance();
    private List<Übung> exercises;

    private EditText editTextName;
    private Button buttonSave;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_uebunganlegen);

        getLayoutInflater().inflate(R.layout.activity_uebunganlegen,constraintLayout);

        ArrayAdapter<CharSequence> adapter_einheiten = ArrayAdapter.createFromResource(this, R.array.einheiten, android.R.layout.simple_spinner_dropdown_item);
        adapter_einheiten.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_einheiten = findViewById(R.id.spinner1);
        spinner_einheiten.setAdapter(adapter_einheiten);
        spinner_einheiten.setOnItemSelectedListener(this);

        spinner_einheiten = findViewById(R.id.spinner2);
        spinner_einheiten.setAdapter(adapter_einheiten);
        spinner_einheiten.setOnItemSelectedListener(this);

        spinner_einheiten = findViewById(R.id.spinner3);
        spinner_einheiten.setAdapter(adapter_einheiten);
        spinner_einheiten.setOnItemSelectedListener(this);

        spinner_einheiten = findViewById(R.id.spinner4);
        spinner_einheiten.setAdapter(adapter_einheiten);
        spinner_einheiten.setOnItemSelectedListener(this);

        spinner_einheiten = findViewById(R.id.spinner5);
        spinner_einheiten.setAdapter(adapter_einheiten);
        spinner_einheiten.setOnItemSelectedListener(this);

        spinner_einheiten = findViewById(R.id.spinner6);
        spinner_einheiten.setAdapter(adapter_einheiten);
        spinner_einheiten.setOnItemSelectedListener(this);

        navigationView.getMenu().getItem(1).setChecked(true);

        buttonSave = findViewById(R.id.buttonSubmit);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveExercise();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void saveExercise() {
        Übung newExercise = new Übung();

        String exerciseName = ((EditText) findViewById(R.id.editÜbungName)).getText().toString();
        String[] attribute = new String[6];
        attribute[0] = ((EditText) findViewById(R.id.editTextText1)).getText().toString();
        attribute[1] = ((EditText) findViewById(R.id.editTextText2)).getText().toString();
        attribute[2] = ((EditText) findViewById(R.id.editTextText3)).getText().toString();
        attribute[3] = ((EditText) findViewById(R.id.editTextText4)).getText().toString();
        attribute[4] = ((EditText) findViewById(R.id.editTextText5)).getText().toString();
        attribute[5] = ((EditText) findViewById(R.id.editTextText6)).getText().toString();

        String[] einheiten = new String[6];
        einheiten[0] = getSelectedSpinnerValue(R.id.spinner1);
        einheiten[1] = getSelectedSpinnerValue(R.id.spinner2);
        einheiten[2] = getSelectedSpinnerValue(R.id.spinner3);
        einheiten[3] = getSelectedSpinnerValue(R.id.spinner4);
        einheiten[4] = getSelectedSpinnerValue(R.id.spinner5);
        einheiten[5] = getSelectedSpinnerValue(R.id.spinner6);

        newExercise.setEinheit(einheiten);
        newExercise.setAttribut(attribute);
        newExercise.setName(exerciseName);
        //Exercise exercise = new Exercise(exerciseName, attribute);

        dm.addExercise(newExercise);
    }

    private String getSelectedSpinnerValue(int spinnerId) {
        Spinner spinner = findViewById(spinnerId);
        return spinner.getSelectedItem().toString();
    }
}