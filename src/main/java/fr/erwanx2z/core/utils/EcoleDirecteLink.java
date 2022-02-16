package fr.erwanx2z.core.utils;

import lombok.Getter;

/**
 * @author Erwan - 2nde5
 */
public enum EcoleDirecteLink {

    ECOLEDIRECTE_LOGIN("https://api.ecoledirecte.com/v3/login.awp"),
    ECOLEDIRECTE_SECTION("https://api.ecoledirecte.com/v3/eleves/"),
    ECOLEDIRECTE_NOTES("/notes.awp?verbe=get&"),
    ECOLEDIRECTE_TOKEN("data={\"token\": \"");
    ;


    @Getter private final String requestName;
    EcoleDirecteLink(String requestName){
        this.requestName = requestName;
    }


}
