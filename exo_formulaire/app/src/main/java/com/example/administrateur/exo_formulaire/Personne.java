package com.example.administrateur.exo_formulaire;

import java.io.Serializable;

/**
 * Created by Administrateur on 15/06/2018.
 */

public class Personne implements Serializable{
    //private int id;
    private String prenom;
    private int age;

    public Personne(String prenom, int age) {
        this.prenom = prenom;
        this.age = age;
    }
/*
    public int getId(){
        return this.id;
    }*/
    public String getPrenom(){
        return this.prenom;
    }
    public int getAge(){
        return this.age;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setAge(int age){
        this.age = age;
    }
}
