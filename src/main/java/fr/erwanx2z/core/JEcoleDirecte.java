package fr.erwanx2z.core;

import fr.erwanx2z.api.JEcoleDirecteAPI;
import fr.erwanx2z.api.cache.ISessionManager;
import fr.erwanx2z.core.cache.SessionManager;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public class JEcoleDirecte extends JEcoleDirecteAPI {

    private final SessionManager sessionManager = new SessionManager();

    @Override
    public ISessionManager getSessionManager() {
        return this.sessionManager;
    }
}
