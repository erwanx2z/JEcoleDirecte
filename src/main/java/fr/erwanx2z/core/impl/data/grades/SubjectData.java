package fr.erwanx2z.core.impl.data.grades;

import fr.erwanx2z.api.impl.data.grades.ISubjectData;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erwan - 2nde5
 */
public class SubjectData implements ISubjectData {
    
    @Getter private final String name;
    @Getter private final String code;

    @Getter private final int coefficient;
    @Getter private final int effectif;

    @Getter private final double averageMax;
    @Getter private final double averageClasse;
    @Getter private final double averageMin;
    @Getter private final double averagePerso;

    @Getter private final List<String> professeursList = new ArrayList<>();

    public SubjectData(JSONObject jsonObject, PeriodeData periodeData){
        this.name = jsonObject.getString("discipline");
        this.code = jsonObject.getString("codeMatiere");

        this.coefficient = jsonObject.getInt("coef");
        this.effectif = jsonObject.getInt("effectif");

        if(jsonObject.getString("moyenneMax").isEmpty())
            this.averageMax = -1;
        else
            this.averageMax = Double.parseDouble(jsonObject.getString("moyenneMax").replace(",", "."));

        if(jsonObject.getString("moyenneMin").isEmpty())
            this.averageMin = -1;
        else
            this.averageMin = Double.parseDouble(jsonObject.getString("moyenneMin").replace(",", "."));


        if(jsonObject.getString("moyenneClasse").isEmpty())
            this.averageClasse = -1;
        else
            this.averageClasse = Double.parseDouble(jsonObject.getString("moyenneClasse").replace(",", "."));

        if(jsonObject.getString("moyenne").isEmpty())
            this.averagePerso = -1;
        else
            this.averagePerso = Double.parseDouble(jsonObject.getString("moyenne").replace(",", "."));

        JSONArray jsonArray = jsonObject.getJSONArray("professeurs");
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            this.professeursList.add(jsonObject1.getString("nom"));
        }

        periodeData.getStringSubjectDataMap().put(this.code, this);
    }
}
