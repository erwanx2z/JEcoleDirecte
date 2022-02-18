package fr.erwanx2z.core.impl.data.sanctions;

import fr.erwanx2z.api.impl.data.sanctions.ISanctionData;
import fr.erwanx2z.common.SanctionType;
import lombok.Getter;
import org.json.JSONObject;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public class SanctionData implements ISanctionData {

    @Getter private final String date;
    @Getter private final String fullData;
    @Getter private final String duration;
    @Getter private final String reason;
    @Getter private final SanctionType sanctionType;
    @Getter private final boolean justified;
    @Getter private final int sanctionId;

    public SanctionData(JSONObject jsonObject){
        this.date = jsonObject.getString("date");
        this.fullData = jsonObject.getString("displayDate");
        this.duration = jsonObject.getString("libelle");
        this.justified = jsonObject.getBoolean("justifie");
        this.reason = justified ? jsonObject.getString("motif") : "Aucun motif (non-justifié)";
        this.sanctionId = jsonObject.getInt("id");

        if (jsonObject.getString("typeElement").equals("Retard"))
            this.sanctionType = SanctionType.RETARD;
        else if (jsonObject.getString("typeElement").equals("Absence"))
            this.sanctionType = SanctionType.ABSENCE;
        else
            this.sanctionType = SanctionType.AUTRE;

    }

}
