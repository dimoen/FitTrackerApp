package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class UebungTracken extends NavMenu implements AdapterView.OnItemSelectedListener{

    private Spinner spinner_uebungen;
    DataManager dm = DataManager.getInstance();

    List<String> uebungNames;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_uebung_tracken,constraintLayout);

        for(Übung u: dm.getExercises_List()){
            uebungNames.add(u.getName());
        }

        ArrayAdapter<CharSequence> adapter_uebungen = ArrayAdapter.createFromResource(this, R.array.uebungen, android.R.layout.simple_spinner_dropdown_item);
        adapter_uebungen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_uebungen = findViewById(R.id.spinner12);

        spinner_uebungen.setAdapter(adapter_uebungen);
        spinner_uebungen.setOnItemSelectedListener(this);

        navigationView.getMenu().getItem(2).setChecked(true);


    }


    private void uebungTracken(){



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}