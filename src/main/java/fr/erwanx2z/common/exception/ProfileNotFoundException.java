package fr.erwanx2z.common.exception;

/**
 * This file is a part of JEcoleDirecte, an Open-Source library
 */
public class ProfileNotFoundException extends Exception {

    @Override
    public void printStackTrace() {
        System.out.println("JEcoleDirecte: Ce profil n'a pas réussi à être trouvé. (Mot de passe invalide)");
    }
}
