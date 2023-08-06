package com.example.myapplication;

import android.os.Environment;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JsonIO {

    public void saveWeight(double w) throws IOException {
        String fnamew = "weight.txt";
        File pathw = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File filew = new File(pathw, "/" + fnamew);
        Log.i("MENU_DRAWER_TAG", filew.getPath());
        FileOutputStream out = new FileOutputStream(filew);

        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writer.beginArray();
        writer.beginObject();
        writer.name("weight").value(w);
        writer.endObject();
        writer.endArray();
        writer.close();
    }

    public double getWeight() throws IOException {
        String fnamew = "weight.txt";
        File pathw = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File filew = new File(pathw, "/" + fnamew);
        Log.i("MENU_DRAWER_TAG", filew.getPath());
        FileInputStream in = new FileInputStream(filew);


        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginArray();
        reader.beginObject();
        Double v = 0.0;
        while (reader.hasNext()) {

            String name = reader.nextName();
            if (name.equals("weight")) {
                v =  Double.parseDouble(reader.nextString());
            }else {
                reader.skipValue();
            }
        }
        return v;
    }




    public void dumpWorkouts(List<Workout> workoutList) throws IOException {

        String fnamew = "workouts.txt";
        File pathw = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File filew = new File(pathw, "/" + fnamew);
        Log.i("MENU_DRAWER_TAG", filew.getPath());
        FileOutputStream out = new FileOutputStream(filew);


        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writeWorkoutList(writer, workoutList);
        writer.close();
    }

    private void writeWorkoutList(JsonWriter writer, List<Workout> workoutList) throws IOException {
        writer.beginArray();
        for (Workout w : workoutList) {
            writeWorkout(writer, w);
        }
        writer.endArray();
    }

    private void writeWorkout(JsonWriter writer, Workout w) throws IOException {
        writer.beginObject();
        writer.name("Name").value(w.getName());
        for (int i= 0; i<6; i++){
            if(w.getExercises()[i] == null){
                writer.name("Übung" + i).value("Null");
            }else{
                writer.name("Übung" + i).value(w.getExercises()[i].getName());
            }
        }
                writer.endObject();
        Log.i("MENU_DRAWER_TAG", "Wrote Workout to JSON");
    }




    public List<Workout> readWorkouts() throws IOException {
        String fnamew = "workouts.txt";
        File pathw = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File filew = new File(pathw, "/" + fnamew);
        Log.i("MENU_DRAWER_TAG", filew.getPath());

        FileInputStream in = new FileInputStream(filew);



        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        List<Workout> workoutList = new ArrayList<Workout>();
        List<Übung> uList = new ArrayList<Übung>();
        try {
            workoutList = readWorkoutArray(reader);
        } finally {
            reader.close();
        }
        return workoutList;
    }

    private List<Workout> readWorkoutArray(JsonReader reader) throws IOException {
        List<Workout> workoutList = new ArrayList<Workout>();

        reader.beginArray();
        while (reader.hasNext()) {
            workoutList.add(readWorkout(reader));
        }
        reader.endArray();
        return workoutList;
    }

    private Workout readWorkout(JsonReader reader) throws IOException {
        Log.i("MENU_DRAWER_TAG", "Reading Workout...");
        Workout w = new Workout();
        Übung[] uList = new Übung[6];
        String[] uNames = new String[6];

        reader.beginObject();
        while (reader.hasNext()) {

            String name = reader.nextName();
            if (name.equals("Name")) {
                w.setName(reader.nextString());
            }else if (name.equals("Übung0")) {
                uNames[0] = reader.nextString();
            }else if (name.equals("Übung1")) {
                uNames[1] = reader.nextString();
            }else if (name.equals("Übung2")) {
                uNames[2] = reader.nextString();
            }else if (name.equals("Übung3")) {
                uNames[3] = reader.nextString();
            }else if (name.equals("Übung4")) {
                uNames[4] = reader.nextString();
            }else if (name.equals("Übung5")) {
                uNames[5] = reader.nextString();
            }else {
                reader.skipValue();
            }
        }

        for(int i = 0; i<6; i++){
            uList[i] = new Übung();
            uList[i].setName(uNames[i]);
        }

        w.setExercises(uList);

        reader.endObject();
        return w;
    }
















    public void dumpExercises(List<Übung> exerciseList) throws IOException {

        String fname = "dataStore.txt";
        //File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(path, "/" + fname);
        Log.i("MENU_DRAWER_TAG", file.getPath());
        FileOutputStream out = new FileOutputStream(file);

        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writeExerciseList(writer, exerciseList);
        writer.close();
    }
    private void writeExerciseList(JsonWriter writer, List<Übung> exerciseList) throws IOException {
        writer.beginArray();
        for (Übung u : exerciseList) {
            writeMessage(writer, u);
        }
        writer.endArray();
    }

    private void dumpExercise(OutputStream out, Übung u) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writeMessagesArray(writer, u);
        writer.close();
    }

    private void writeMessagesArray(JsonWriter writer, Übung u) throws IOException {
        writer.beginArray();
        writeMessage(writer, u);
        writer.endArray();
    }

    private void writeMessage(JsonWriter writer, Übung u) throws IOException {
        writer.beginObject();
        writer.name("Name").value(u.getName());
        for (int i= 0; i<6; i++){
            if(u.getAttribut()[i] == null){
                writer.name("Attribut" + i).value("Null");
            }else{
                writer.name("Attribut" + i).value(u.getAttribut()[i]);
            }
        }
        for (int i= 0; i<6; i++){
            if(u.getEinheit()[i] == null){
                writer.name("Einheit" + i).value("Null");
            }else{
                writer.name("Einheit" + i).value(u.getEinheit()[i]);
            }
        }

        int i =0;
        for(DataPoint d: u.dataPoints){
            writer.name(String.valueOf(i));
            writeData(writer, d);
            i++;
        }

        writer.endObject();
        Log.i("MENU_DRAWER_TAG", "Wrote Exercise to JSON");
    }
    private void writeData(JsonWriter writer, DataPoint d) throws IOException {
        writer.beginObject();
        for(int i = 0; i<6; i++){
            writer.name(String.valueOf(i)).value(d.aList[i]);
        }
        writer.name("timestamp").value(String.valueOf(d.timestamp));
        writer.endObject();
    }


    public List<Übung> readExercises() throws IOException {
        String fname = "dataStore.txt";
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, "/" + fname);
        Log.i("MENU_DRAWER_TAG", file.getPath());

        FileInputStream in = new FileInputStream(file);



        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readExerciseArray(reader);
        } finally {
            reader.close();
        }
    }

    private List<Übung> readExerciseArray(JsonReader reader) throws IOException {
        List<Übung> rexerciseList = new ArrayList<Übung>();

        reader.beginArray();
        while (reader.hasNext()) {
            rexerciseList.add(readMessage(reader));
        }
        reader.endArray();
        return rexerciseList;
    }


    private Übung readExercise(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessage(reader);
        } finally {
            reader.close();
        }
    }

    private Übung readMessage(JsonReader reader) throws IOException {
        Log.i("MENU_DRAWER_TAG", "Reading Data...");
        Übung u = new Übung();
        String[] aList = new String[6];
        String[] eList = new String[6];

        reader.beginObject();
        Log.i("MENU_DRAWER_TAG", "hier");
        while (reader.hasNext()) {

            String name = reader.nextName();
            if (name.equals("Name")) {
                u.setName(reader.nextString());
            } else if (name.equals("Attribut0")) {
                aList[0] = reader.nextString();
            } else if (name.equals("Attribut1")) {
                aList[1] = reader.nextString();
            } else if (name.equals("Attribut2")) {
                aList[2] = reader.nextString();
            } else if (name.equals("Attribut3")) {
                aList[3] = reader.nextString();
            } else if (name.equals("Attribut4")) {
                aList[4] = reader.nextString();
            } else if (name.equals("Attribut5")) {
                aList[5] = reader.nextString();
            } else if (name.equals("Einheit0")) {
                eList[0] = reader.nextString();
            } else if (name.equals("Einheit1")) {
                eList[1] = reader.nextString();
            } else if (name.equals("Einheit2")) {
                eList[2] = reader.nextString();
            } else if (name.equals("Einheit3")) {
                eList[3] = reader.nextString();
            } else if (name.equals("Einheit4")) {
                eList[4] = reader.nextString();
            } else if (name.equals("Einheit5")) {
                eList[5] = reader.nextString();
            } else {
                Log.i("MENU_DRAWER_TAG", name);
                Log.i("MENU_DRAWER_TAG", "Adding DataPoints...");
                u.dataPoints.add(readDataPoint(reader));
                Log.i("MENU_DRAWER_TAG", "Added DataPoint...");
            }
        }



        reader.endObject();
        u.setAttribut(aList);
        u.setEinheit(eList);
        return u;
    }


    private DataPoint readDataPoint(JsonReader reader) throws IOException {
        Log.i("MENU_DRAWER_TAG", "Adding DataPoint...");

        DataPoint d = new DataPoint();
        Log.i("MENU_DRAWER_TAG", "hier");


        try {
            reader.beginObject();
        }catch (Exception e){
            Log.i("MENU_DRAWER_TAG", e.getMessage());
        }
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("0")) {
                d.aList[0] = reader.nextDouble();
            } else if (name.equals("1")) {
                d.aList[1] = reader.nextDouble();
            } else if (name.equals("2")) {
                d.aList[2] = reader.nextDouble();
            } else if (name.equals("3")) {
                d.aList[3] = reader.nextDouble();
            } else if (name.equals("4")) {
                d.aList[4] = reader.nextDouble();
            } else if (name.equals("5")) {
                d.aList[5] = reader.nextDouble();
            } else if (name.equals("timestamp")) {
                d.timestamp = Timestamp.valueOf(reader.nextString());
            }  else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return d;
    }

}
