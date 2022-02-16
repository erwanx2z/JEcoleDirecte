package fr.erwanx2z.core.utils.exception;

/**
 * @author Erwan - 2nde5
 */
public class ProfileNotFoundException extends Exception {

    @Override
    public void printStackTrace() {
        System.out.println("JEcoleDirecte: Ce profil n'a pas réussi à être trouvé. (Mot de passe invalide)");
    }
}
