package fr.erwanx2z.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Erwan - 2nde5
 */
public class RequestUtils {

    public static String sendRequest(String username, String password) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(EcoleDirecteLink.ECOLEDIRECTE_LOGIN.getRequestName()).openConnection();
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");
            connection.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
            connection.addRequestProperty("Pragma", "no-cache");

            PrintWriter pw = new PrintWriter(connection.getOutputStream());
            pw.write("data={\"identifiant\": \"" + username + "\", \"motdepasse\": \"" + password + "\"}");
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder result = new StringBuilder();
            String f = br.readLine();
            while(f != null) {
                result.append(f).append("\n");
                f = br.readLine();

                br.close();
            }

            connection.disconnect();
            return result.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
