package fr.erwanx2z.api.impl.data.sanctions;

import fr.erwanx2z.common.SanctionType;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public interface ISanctionData {

    //Permet d'obtenir la date de l'absence ou du retard. (Format: XX/XX/XXXX)
    String getDate();

    //Permet d'obtenir la date complète de l'absence ou du retard. (Format: 18 février 2022 à 18h11)
    String getFullData();

    //Durée de l'absence (en demi-journées: 2 demi-journées) ou du retard (en minutes: XX:xx)
    String getDuration();

    //Permet de récupérer le motif de l'absence présenté à la vie scolaire.
    String getReason();

    //Permet de récupérer le type de la sanction (Retard/Absence/Autre)
    SanctionType getSanctionType();

    //Permet de savoir si cette sanction est justifiée ou non.
    boolean isJustified();

    //Permet de récupérer l'ID de cette sanction.
    int getSanctionId();
}
