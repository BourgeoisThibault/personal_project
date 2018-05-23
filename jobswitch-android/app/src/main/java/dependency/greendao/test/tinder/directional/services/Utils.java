package dependency.greendao.test.tinder.directional.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by RubenEdery on 18/03/2018.
 */

public class Utils {


    public String get_SHA_512_SecurePassword(String passwordToHash){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest(passwordToHash.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }


    public String getReturnCodeHttp(String code){
        String textReturnOtherError = "Erreur d'authentification";
        String textReturn404 = "Identifiant inconnu";
        String textReturn401 = "Mot de passe incorrect";

        if(code.equals("404")){
            return textReturn404;
        }
        else if(code.equals("401")){
            return textReturn401;
        }
        else {
            return textReturnOtherError;
        }

    }



}
