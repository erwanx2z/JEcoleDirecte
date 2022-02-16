package fr.erwanx2z.api;

import fr.erwanx2z.api.cache.ISessionManager;

/**
 * @author Erwan - 2nde5
 */
public abstract class JEcoleDirecteAPI {

    private static JEcoleDirecteAPI instance;

    //Permet de récupérer l'API.
    public static JEcoleDirecteAPI getApi() {
        return instance;
    }

    //Permet de définir notre class principale de notre API.
    public static void setEcoleDirecte(JEcoleDirecteAPI instance) {
        if (JEcoleDirecteAPI.instance != null)
            throw new IllegalArgumentException("Cannot set new instance of JEcoleDirecteAPI!");
        JEcoleDirecteAPI.instance = instance;
    }

    //Permet de récupérer la SessionManager, pour créer & récupérer des Sessions.
    public abstract ISessionManager getSessionManager();


}
