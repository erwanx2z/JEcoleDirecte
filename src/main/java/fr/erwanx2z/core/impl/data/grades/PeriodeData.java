package fr.erwanx2z.core.impl.data.grades;

import fr.erwanx2z.api.impl.data.grades.IPeriodeData;
import fr.erwanx2z.core.impl.data.GradeLoader;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Erwan - 2nde5
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

    @Getter private final double averageMax;
    @Getter private final double averageClasse;
    @Getter private final double averageMin;
    @Getter private final double averagePerso;


    public PeriodeData(JSONObject jsonObject, GradeLoader gradeLoader){

        this.examenBlanc = jsonObject.getBoolean("examenBlanc");
        this.finish = jsonObject.getBoolean("cloture");
        this.periodeId = jsonObject.getString("idPeriode");
        this.periodeName = jsonObject.getString("periode");

        this.periodeCode = jsonObject.getString("codePeriode");
        this.beginDate = jsonObject.getString("dateDebut");
        this.endDate = jsonObject.getString("dateFin");


        JSONObject matieres = jsonObject.getJSONObject("ensembleMatieres");
        if(matieres.getString("moyenneMax").isEmpty())
            this.averageMax = -1;
        else
            this.averageMax = Double.parseDouble(matieres.getString("moyenneMax").replace(",", "."));

        if(matieres.getString("moyenneMin").isEmpty())
            this.averageMin = -1;
        else
            this.averageMin = Double.parseDouble(matieres.getString("moyenneMin").replace(",", "."));


        if(matieres.getString("moyenneClasse").isEmpty())
            this.averageClasse = -1;
        else
            this.averageClasse = Double.parseDouble(matieres.getString("moyenneClasse").replace(",", "."));

        if(matieres.getString("moyenneGenerale").isEmpty())
            this.averagePerso = -1;
        else
            this.averagePerso = Double.parseDouble(matieres.getString("moyenneGenerale").replace(",", "."));


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
