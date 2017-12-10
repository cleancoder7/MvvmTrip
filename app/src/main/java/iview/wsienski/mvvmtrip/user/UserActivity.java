package iview.wsienski.mvvmtrip.user;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseActivity;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class UserActivity extends BaseActivity {

    private static final String USER_FRAGMENT = "USER_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);

        FragmentManager manager = getSupportFragmentManager();

        UserFragment fragment = (UserFragment) manager.findFragmentByTag(USER_FRAGMENT);

        if (fragment == null) {
            fragment = UserFragment.newInstance();
        }

        addFragmentToActivity(manager,
                fragment,
                R.id.root_activity_user,
                USER_FRAGMENT
        );

    }

}
