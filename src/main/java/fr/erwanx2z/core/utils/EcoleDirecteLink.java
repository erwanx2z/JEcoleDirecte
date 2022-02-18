package fr.erwanx2z.core.utils;

import lombok.Getter;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public enum EcoleDirecteLink {

    ECOLEDIRECTE_LOGIN("https://api.ecoledirecte.com/v3/login.awp"),
    ECOLEDIRECTE_SECTION("https://api.ecoledirecte.com/v3/eleves/"),
    ECOLEDIRECTE_NOTES("/notes.awp?verbe=get&"),
    ECOLEDIRECTE_VIESCOLAIRE("/viescolaire.awp?verbe=get"),
    ECOLEDIRECTE_TOKEN("data={\"token\": \"");
    ;


    @Getter private final String requestName;
    EcoleDirecteLink(String requestName){
        this.requestName = requestName;
    }


}
