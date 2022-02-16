package fr.erwanx2z.core.impl.data;

import fr.erwanx2z.api.impl.data.IClassroom;
import lombok.Getter;
import org.json.JSONObject;

/**
 * @author Erwan - 2nde5
 */
public class Classroom implements IClassroom {

    @Getter private final int id;
    @Getter private final String code;
    @Getter private final String libelle;

    public Classroom(JSONObject jsonObject){
        this.id = jsonObject.getInt("id");
        this.code = jsonObject.getString("code");
        this.libelle = jsonObject.getString("libelle");
    }
}
