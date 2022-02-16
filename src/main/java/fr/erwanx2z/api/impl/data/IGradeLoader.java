package fr.erwanx2z.api.impl.data;

import fr.erwanx2z.api.impl.IProfile;
import fr.erwanx2z.api.impl.data.grades.IPeriodeData;
import fr.erwanx2z.core.impl.Profile;
import fr.erwanx2z.core.impl.data.grades.PeriodeData;
import fr.erwanx2z.core.impl.data.grades.SubjectData;
import fr.erwanx2z.core.utils.EcoleDirecteLink;
import fr.erwanx2z.core.utils.RequestUtils;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Erwan - 2nde5
 */
public interface IGradeLoader {

    //Permet de récupérer le profile associé à ces notes
    IProfile getProfile();


    /**
     *
     *  Vous permet de récupérer les informations d'une période.
     *  Si aucune période n'existe avec ce code, une NPE se produira (NPE = NullPointerException).
     *
     * @param code le nom de code de la période (exemple: A001)
     *
     */
    IPeriodeData getPeriodeData(String code);

}
