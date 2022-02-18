package fr.erwanx2z.core.impl;

import fr.erwanx2z.api.impl.IProfile;
import fr.erwanx2z.core.impl.data.Classroom;
import fr.erwanx2z.core.impl.data.GradeLoader;
import fr.erwanx2z.core.impl.data.SanctionsLoader;
import lombok.Getter;
import org.json.JSONObject;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public class Profile implements IProfile {

    @Getter private final Session session;
    @Getter private final Classroom classroom;
    @Getter private final GradeLoader gradeLoader;
    @Getter private final SanctionsLoader sanctionsLoader;

    @Getter private final String firstName;
    @Getter private final String lastName;
    @Getter private final String mail;
    @Getter private final String genre;
    @Getter private final String lastConnectionDate;
    @Getter private final int accountId;

    public Profile(JSONObject jsonObject, Session session){
        this.session = session;

        JSONObject accountData = jsonObject.getJSONObject("data").getJSONArray("accounts").getJSONObject(0);

        this.firstName = accountData.getString("prenom");
        this.lastName = accountData.getString("nom");
        this.mail = accountData.getString("email");
        this.lastConnectionDate = accountData.getString("lastConnexion");
        this.accountId = accountData.getInt("id");

        JSONObject profileData = accountData.getJSONObject("profile");
        this.classroom = new Classroom(profileData.getJSONObject("classe"));
        this.genre = profileData.getString("sexe").equals("M") ? "Garçon" : "Fille";

        this.gradeLoader = new GradeLoader(this);
        this.sanctionsLoader = new SanctionsLoader(this);
    }

}
