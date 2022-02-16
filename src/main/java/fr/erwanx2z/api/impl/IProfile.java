package fr.erwanx2z.api.impl;

import fr.erwanx2z.api.impl.data.IClassroom;
import fr.erwanx2z.api.impl.data.IGradeLoader;

/**
 * @author Erwan - 2nde5
 */
public interface IProfile {


    //Permet de récupérer la Session de ce profile.
    ISession getSession();

    //Permet de récupérer la Classe de l'élève utilisé sur ce profile.
    IClassroom getClassroom();

    //Permet de récupérer les notes de l'élève.
    IGradeLoader getGradeLoader();

    //Permet de récupérer le prénom de l'élève.
    String getFirstName();

    //Permet de récupérer le nom de famille de l'élève.
    String getLastName();

    //Permet de récupérer l'addresse e-mail enregistrée sur ce compte.
    String getMail();

    //Permet de récupérer le genre de l'élève (Garçon/Fille)
    String getGenre();

    //Permet de récupérer la date de dernière connexion au compte.
    String getLastConnectionDate();

    //Permet de récupérer l'ID de son compte sur EcoleDirecte.
    int getAccountId();



}
