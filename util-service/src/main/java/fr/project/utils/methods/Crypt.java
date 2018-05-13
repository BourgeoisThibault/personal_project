package fr.project.utils.methods;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author BOURGEOIS Thibault
 * Date     09/05/2018
 * Time     23:05
 */

public class Crypt {

    public static String getHash (String pwd) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest(pwd.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static Boolean checkCrypt(String passEnter, String passBase) {
        if(passBase.equals(passEnter))
            return true;
        else
            return false;
    }

}
