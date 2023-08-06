package com.example.myapplication;

public class Workout {
    private Übung[] exercises;
    private String name;

    public Übung[] getExercises() {
        return exercises;
    }

    public void setExercises(Übung[] e){
        this.exercises = e;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name = n;
    }
}
