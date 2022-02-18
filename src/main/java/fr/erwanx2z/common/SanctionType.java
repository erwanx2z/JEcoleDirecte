package fr.erwanx2z.common;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public enum SanctionType {

    RETARD("Retard"),
    ABSENCE("Absence"),
    AUTRE("Autre");

    private final String name;

    SanctionType(String name){
        this.name = name;
    }

}
