package fr.erwanx2z.core.cache;

import fr.erwanx2z.api.cache.ISessionManager;
import fr.erwanx2z.core.impl.Session;
import fr.erwanx2z.core.utils.EcoleDirecteLink;
import fr.erwanx2z.core.utils.RequestUtils;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Erwan - 2nde5
 */
public class SessionManager implements ISessionManager {

    @Getter private final Map<String, Session> sessionList = new HashMap<>();

    public Session createSession(String username, String password){
        if(this.sessionList.containsKey(username))
            return this.sessionList.get(username);

        try {
            Session session = new Session(RequestUtils.sendRequest(username, password, EcoleDirecteLink.ECOLEDIRECTE_LOGIN.getRequestName()));
            this.sessionList.put(username, session);
            return session;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Session loadSession(String username){
        return this.sessionList.getOrDefault(username, null);
    }

}
