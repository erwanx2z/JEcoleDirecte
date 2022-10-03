package fr.erwanx2z.core.impl.data.grades;

import fr.erwanx2z.api.impl.data.grades.ISubjectData;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public class SubjectData implements ISubjectData {
    
    @Getter private final String name;
    @Getter private final String code;

    @Getter private final int coefficient;
    @Getter private final int effectif;

    @Getter private final String averageMax;
    @Getter private final String averageClasse;
    @Getter private final String averageMin;
    @Getter private final String averagePerso;

    @Getter private final List<String> professeursList = new ArrayList<>();

    public SubjectData(JSONObject jsonObject, PeriodeData periodeData){
        this.name = jsonObject.getString("discipline");
        this.code = jsonObject.getString("codeMatiere");

        this.coefficient = jsonObject.getInt("coef");
        this.effectif = jsonObject.getInt("effectif");

        if(!jsonObject.has("moyenneMax"))
            this.averageMax = "-1";
        else
            this.averageMax = jsonObject.getString("moyenneMax").replace(",", ".");

        if(!jsonObject.has("moyenneMin"))
            this.averageMin = "-1";
        else
            this.averageMin = jsonObject.getString("moyenneMin").replace(",", ".");


        if(!jsonObject.has("moyenneClasse"))
            this.averageClasse = "-1";
        else
            this.averageClasse = jsonObject.getString("moyenneClasse").replace(",", ".");

        if(!jsonObject.has("moyenne"))
            this.averagePerso = "-1";
        else
            this.averagePerso = jsonObject.getString("moyenne").replace(",", ".");

        JSONArray jsonArray = jsonObject.getJSONArray("professeurs");
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            this.professeursList.add(jsonObject1.getString("nom"));
        }

        periodeData.getStringSubjectDataMap().put(this.code, this);
    }
}
