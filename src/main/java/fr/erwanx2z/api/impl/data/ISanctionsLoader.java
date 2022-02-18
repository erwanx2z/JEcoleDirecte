package fr.erwanx2z.api.impl.data;

import fr.erwanx2z.api.impl.IProfile;
import fr.erwanx2z.api.impl.data.sanctions.ISanctionData;
import fr.erwanx2z.common.SanctionType;

import java.util.List;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public interface ISanctionsLoader {

    //Permet de récupérer le profile associé à ces sanctions
    IProfile getProfile();


    /**
     *
     *  Vous permet de récupérer les sanctions (retards & absences) de l'élève.
     *
     * @param sanctionType le type de sanction que vous voulez récupérer.
     *
     */
    List<ISanctionData> sortByType(SanctionType sanctionType);

}
