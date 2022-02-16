package fr.erwanx2z.api.cache;

import fr.erwanx2z.api.impl.ISession;
import fr.erwanx2z.core.utils.exception.ProfileNotFoundException;

/**
 * @author Erwan - 2nde5
 */
public interface ISessionManager {

    /**
     *
     *  Vous permet de créer une session EcoleDirecte.
     *  Si une session avec le même nom d'utilisateur est déjà existante, elle sera sortie du cache.
     *  De plus, si le mot de passe est incorrect, une erreur entrera alors en action (soit la mienne, soit une NPE - NullPointerException).
     *
     * @param username votre nom d'utilisateur
     * @param password votre mot de passe
     *
     */
    ISession createSession(String username, String password) throws ProfileNotFoundException;

    /**
     *
     *  Vous permet de récupérer une Session déjà créée précédemment. Elle retourne null si il n'y en a pas.
     *
     * @param username le nom d'utilisateur de la session que vous souhaitez récupérer
     */
    ISession loadSession(String username);

}
