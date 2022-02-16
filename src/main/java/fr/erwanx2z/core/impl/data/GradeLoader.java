package fr.erwanx2z.core.impl.data;

import fr.erwanx2z.api.impl.data.IGradeLoader;
import fr.erwanx2z.core.impl.Profile;
import fr.erwanx2z.core.impl.data.grades.PeriodeData;
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
public class GradeLoader implements IGradeLoader {

    @Getter private final Profile profile;
    @Getter private final Map<String, PeriodeData> stringJSONObjectMap = new HashMap<>();

    public GradeLoader(Profile profile){
        this.profile = profile;

        JSONObject jsonData = new JSONObject(RequestUtils.sendRequest(null, null, EcoleDirecteLink.ECOLEDIRECTE_TOKEN.getRequestName() + profile.getSession().getToken() + "\"}", EcoleDirecteLink.ECOLEDIRECTE_SECTION.getRequestName() + profile.getAccountId() + EcoleDirecteLink.ECOLEDIRECTE_NOTES.getRequestName()));
        JSONObject jsonArray = jsonData.getJSONObject("data");
        JSONArray jsonObject = jsonArray.getJSONArray("periodes");
        for(int i = 0; i < jsonObject.length(); i++){
            JSONObject notes = jsonObject.getJSONObject(i);
            new PeriodeData(notes, this);
        }
    }

    public PeriodeData getPeriodeData(String code){
        return stringJSONObjectMap.getOrDefault(code, null);
    }

}
