package fr.erwanx2z.core;

import fr.erwanx2z.api.JEcoleDirecteAPI;
import fr.erwanx2z.api.cache.ISessionManager;
import fr.erwanx2z.core.cache.SessionManager;

/**
 * @author Erwan - 2nde5
 */
public class JEcoleDirecte extends JEcoleDirecteAPI {

    private final SessionManager sessionManager = new SessionManager();

    @Override
    public ISessionManager getSessionManager() {
        return this.sessionManager;
    }
}
