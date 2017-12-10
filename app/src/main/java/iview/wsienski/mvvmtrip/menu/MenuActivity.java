package iview.wsienski.mvvmtrip.menu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseActivity;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class MenuActivity extends BaseActivity {

    private static final String MENU_FRAGMENT = "MENU_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        FragmentManager manager = getSupportFragmentManager();

        MenuFragment fragment = (MenuFragment) manager.findFragmentByTag(MENU_FRAGMENT);

        if (fragment == null) {
            fragment = MenuFragment.newInstance();
        }

        addFragmentToActivity(manager,
                fragment,
                R.id.root_activity_menu,
                MENU_FRAGMENT
        );

    }
}
