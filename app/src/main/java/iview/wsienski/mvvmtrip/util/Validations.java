package iview.wsienski.mvvmtrip.util;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class Validations {

    public static boolean checkEmail(String email) {
        return !isEmpty(email) && email.contains("@");
    }

    private static boolean isEmpty(String email) {
        return email == null || email.length() <= 0;
    }
}
