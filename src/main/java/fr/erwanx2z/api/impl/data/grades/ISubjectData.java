package fr.erwanx2z.api.impl.data.grades;

import java.util.List;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public interface ISubjectData {

    //Permet de récupérer le nom complet de la matière.
    String getName();

    //Permet de récupérer le code de la matière.
    String getCode();

    //Permet de récupérer le coefficient de cette matière pour cet élève.
    int getCoefficient();

    //Permet de récupérer le nombre d'élèves dans cette matière.
    int getEffectif();

    //Permet de récupérer la moyenne maximale dans cette classe et dans cette matière. (Si inexistant = -1)
    double getAverageMax();

    //Permet de récupérer la moyenne générale de cette classe et dans cette matière. (Si inexistant = -1)
    double getAverageClasse();

    //Permet de récupérer la moyenne minimale dans cette classe et dans cette matière. (Si inexistant = -1)
    double getAverageMin();

    //Permet de récupérer la moyenne générale de l'élève dans cette matière. (Si inexistant = -1)
    double getAveragePerso();

    //Permet de récupérer la liste des professeurs enseignant cette matière.
    List<String> getProfesseursList();

}
