package fr.erwanx2z.api.impl;

import org.json.JSONObject;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public interface ISession {

    //Permet de récupérer le Json brut de cette Session.
    JSONObject getJsonData();

    //Permet de récupérer le Token lié à cette Session.
    String getToken();

    //Permet de récupérer le Profile associé à cette Session.
    IProfile getProfile();
}
