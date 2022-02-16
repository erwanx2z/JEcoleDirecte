package fr.erwanx2z.core.impl;

import fr.erwanx2z.api.impl.ISession;
import fr.erwanx2z.core.utils.exception.ProfileNotFoundException;
import lombok.Getter;
import org.json.JSONObject;

/**
 * @author Erwan - 2nde5
 */
public class Session implements ISession {

    @Getter private final JSONObject jsonData;
    @Getter private final String token;
    @Getter private final Profile profile;

    public Session(String link) throws ProfileNotFoundException {
        if(link.contains("Mot de passe invalide"))
            throw new ProfileNotFoundException();

        this.jsonData = new JSONObject(link);
        this.token = jsonData.getString("token");

        this.profile = new Profile(jsonData, this);
    }
}
