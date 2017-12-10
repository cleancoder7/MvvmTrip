package iview.wsienski.mvvmtrip.messagelive;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseActivity;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class MessageLiveActivity extends BaseActivity {

    private static final String MESSAGE_FRAGMENT = "MESSAGE_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);

        FragmentManager manager = getSupportFragmentManager();

        MessageFragment fragment = (MessageFragment) manager.findFragmentByTag(MESSAGE_FRAGMENT);

        if (fragment == null) {
            fragment = MessageFragment.newInstance();
        }

        addFragmentToActivity(manager,
                fragment,
                R.id.root_activity_message,
                MESSAGE_FRAGMENT
        );

    }
}
