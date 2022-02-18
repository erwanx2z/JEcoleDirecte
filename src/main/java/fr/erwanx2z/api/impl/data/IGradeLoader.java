package fr.erwanx2z.api.impl.data;

import fr.erwanx2z.api.impl.IProfile;
import fr.erwanx2z.api.impl.data.grades.IPeriodeData;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
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
