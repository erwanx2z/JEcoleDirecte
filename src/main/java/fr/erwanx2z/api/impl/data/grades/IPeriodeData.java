package fr.erwanx2z.api.impl.data.grades;

import fr.erwanx2z.core.impl.data.grades.SubjectData;

import java.util.Map;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public interface IPeriodeData {

    //Permet d'obtenir la HashMap avec toutes les matières de cette période.
    Map<String, SubjectData> getStringSubjectDataMap();

    //Permet de savoir si cette période est un examen blanc.
    boolean isExamenBlanc();

    //Permet de savoir si cette période est finie.
    boolean isFinish();

    //Permet de récupérer l'ID de cette période.
    String getPeriodeId();

    //Permet de récupérer le nom de cette période.
    String getPeriodeName();

    //Permet de récupérer le code de cette période.
    String getPeriodeCode();

    //Permet de récupérer la date de début de cette période.
    String getBeginDate();

    //Permet de récupérer la date de fin de cette période.
    String getEndDate();


    //Permet de récupérer la moyenne maximale dans cette classe pendant cette période. (Si inexistant = -1)
    double getAverageMax();

    //Permet de récupérer la moyenne générale de cette classe pendant cette période. (Si inexistant = -1)
    double getAverageClasse();

    //Permet de récupérer la moyenne minimale dans cette classe pendant cette période. (Si inexistant = -1)
    double getAverageMin();

    //Permet de récupérer la moyenne générale de l'élève sur la période.
    double getAveragePerso();

    /**
     *
     *  Vous permet de récupérer les informations d'une matière.
     *  Si aucune matière n'existe avec ce code, une NPE se produira (NPE = NullPointerException).
     *
     * @param subjectCode le code de la matière (exemple: MATHS)
     *
     */
    ISubjectData getSubjectData(String subjectCode);

}
