package fr.erwanx2z.core.impl.data.grades;

import fr.erwanx2z.api.impl.data.grades.IPeriodeData;
import fr.erwanx2z.core.impl.data.GradeLoader;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public class PeriodeData implements IPeriodeData {

    @Getter private final Map<String, SubjectData> stringSubjectDataMap = new HashMap<>();
    @Getter private final boolean examenBlanc;
    @Getter private final boolean finish;

    @Getter private final String periodeId;
    @Getter private final String periodeName;
    @Getter private final String periodeCode;

    @Getter private final String beginDate;
    @Getter private final String endDate;

    @Getter private final String averageMax;
    @Getter private final String averageClasse;
    @Getter private final String averageMin;
    @Getter private final String averagePerso;


    public PeriodeData(JSONObject jsonObject, GradeLoader gradeLoader){

        this.examenBlanc = jsonObject.getBoolean("examenBlanc");
        this.finish = jsonObject.getBoolean("cloture");
        this.periodeId = jsonObject.getString("idPeriode");
        this.periodeName = jsonObject.getString("periode");

        this.periodeCode = jsonObject.getString("codePeriode");
        this.beginDate = jsonObject.getString("dateDebut");
        this.endDate = jsonObject.getString("dateFin");


        JSONObject matieres = jsonObject.getJSONObject("ensembleMatieres");
        if(!matieres.has("moyenneMax"))
            this.averageMax = "-1";
        else
            this.averageMax = matieres.getString("moyenneMax").replace(",", ".");

        if(!matieres.has("moyenneMin"))
            this.averageMin = "-1";
        else
            this.averageMin = matieres.getString("moyenneMin").replace(",", ".");


        if(!matieres.has("moyenneClasse"))
            this.averageClasse = "-1";
        else
            this.averageClasse = matieres.getString("moyenneClasse").replace(",", ".");

        if(!matieres.has("moyenneGenerale"))
            this.averagePerso = "-1";
        else
            this.averagePerso = matieres.getString("moyenneGenerale").replace(",", ".");


        JSONArray disciplines = matieres.getJSONArray("disciplines");

        for(int i = 0; i < disciplines.length(); i++){
            JSONObject notes = disciplines.getJSONObject(i);
            new SubjectData(notes, this);
        }

        gradeLoader.getStringJSONObjectMap().put(this.periodeCode, this);
    }

    public SubjectData getSubjectData(String periodeCode){
        return getStringSubjectDataMap().getOrDefault(periodeCode, null);
    }



}
