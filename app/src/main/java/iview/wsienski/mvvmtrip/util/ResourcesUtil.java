package iview.wsienski.mvvmtrip.util;

import android.content.Context;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class ResourcesUtil {

    private Context applicationContext;

    public ResourcesUtil(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String getString(int id) {
        return applicationContext.getString(id);
    }

}
