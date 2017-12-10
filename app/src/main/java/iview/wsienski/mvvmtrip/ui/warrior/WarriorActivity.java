package iview.wsienski.mvvmtrip.ui.warrior;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseActivity;

public class WarriorActivity extends BaseActivity {

    private static final String WARRIOR_FRAGMENT = "WARRIOR_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warrior_activity);

        FragmentManager manager = getSupportFragmentManager();

        WarriorFragment fragment = (WarriorFragment) manager.findFragmentByTag(WARRIOR_FRAGMENT);

        if (fragment == null) {
            fragment = WarriorFragment.newInstance();
        }

        addFragmentToActivity(manager,
                fragment,
                R.id.root_activity_warrior,
                WARRIOR_FRAGMENT
        );

    }
}
