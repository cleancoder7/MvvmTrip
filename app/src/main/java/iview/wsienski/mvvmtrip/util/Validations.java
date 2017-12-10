package iview.wsienski.mvvmtrip.util;

import android.text.TextUtils;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class Validations {

    public static boolean checkEmail(String email){
        return !TextUtils.isEmpty(email) && email.contains("@");
    }
}
