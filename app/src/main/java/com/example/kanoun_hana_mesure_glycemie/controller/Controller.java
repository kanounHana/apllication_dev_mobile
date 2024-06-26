package com.example.kanoun_hana_mesure_glycemie.controller;

import com.example.kanoun_hana_mesure_glycemie.model.Patient;

public class Controller {
    private static Patient patient;
    private static Controller instance=null;

    private Controller() {
        super();
    }
    public static final Controller getInstance()
    {
        if (instance == null)
            instance=new Controller();
        return instance;
    }

    // fleche "userAction" view-->controller --> model
    public void createPatient(int age, float valeurMesuree, boolean isFasting)
    {
        patient =new Patient(age,valeurMesuree,isFasting);
    }

    // fleche "notify" controller --> view
    public String getResult()
    {
        return patient.getResult();
    }

}