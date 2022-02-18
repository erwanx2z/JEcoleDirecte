package fr.erwanx2z.core.impl.data;

import fr.erwanx2z.api.impl.data.ISanctionsLoader;
import fr.erwanx2z.api.impl.data.sanctions.ISanctionData;
import fr.erwanx2z.core.impl.Profile;
import fr.erwanx2z.core.impl.data.sanctions.SanctionData;
import fr.erwanx2z.common.SanctionType;
import fr.erwanx2z.core.utils.EcoleDirecteLink;
import fr.erwanx2z.core.utils.RequestUtils;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public class SanctionsLoader implements ISanctionsLoader {

    @Getter private final Profile profile;
    @Getter private final List<SanctionData> sanctionDataList = new ArrayList<>();


    public SanctionsLoader(Profile profile){
        this.profile = profile;

        JSONObject jsonData = new JSONObject(RequestUtils.sendRequest(null, null, EcoleDirecteLink.ECOLEDIRECTE_TOKEN.getRequestName() + profile.getSession().getToken() + "\"}", EcoleDirecteLink.ECOLEDIRECTE_SECTION.getRequestName() + profile.getAccountId() + EcoleDirecteLink.ECOLEDIRECTE_VIESCOLAIRE.getRequestName()));
        JSONArray jsonRetards = jsonData.getJSONObject("data").getJSONArray("absencesRetards");

        for(int i = 0; jsonRetards.length() > i; i++){
            JSONObject jsonObject = jsonRetards.getJSONObject(i);
            sanctionDataList.add(new SanctionData(jsonObject));
        }
    }


    public List<ISanctionData> sortByType(SanctionType sanctionType) {
        return sanctionDataList.stream().filter(sanctionData -> sanctionData.getSanctionType() == sanctionType).collect(Collectors.toList());
    }
}
