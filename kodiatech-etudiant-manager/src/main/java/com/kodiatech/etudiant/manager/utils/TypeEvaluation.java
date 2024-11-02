package com.kodiatech.etudiant.manager.utils;

public enum TypeEvaluation {

    TD("Travaux Dirigés"),
    TP("Travaux Dirigés"),
    EXAMEN("Travaux Dirigés");



    TypeEvaluation(String value){
        setValue(value);
    }

    private  String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
