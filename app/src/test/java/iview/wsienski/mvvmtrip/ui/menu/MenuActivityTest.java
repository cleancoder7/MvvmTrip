package iview.wsienski.mvvmtrip.ui.menu;

import android.content.Intent;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.ui.messagelive.MessageLiveActivity;
import iview.wsienski.mvvmtrip.ui.user.UserActivity;
import iview.wsienski.mvvmtrip.ui.warrior.WarriorActivity;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Witold Sienski on 11.12.2017.
 */
@RunWith(RobolectricTestRunner.class)
public class MenuActivityTest {

    private MenuActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MenuActivity.class);
    }

    @LargeTest
    @Test
    public void clickingMvvmRxJava_shouldStartWarriorActivity() {
        activity.findViewById(R.id.mvvm_rxjava).performClick();

        Intent expectedIntent = new Intent(activity, WarriorActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @LargeTest
    @Test
    public void clickingMvvmLiveData_shouldStartMessageLiveActivity() {
        activity.findViewById(R.id.mvvm_livedata).performClick();

        Intent expectedIntent = new Intent(activity, MessageLiveActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @LargeTest
    @Test
    public void clickingMvvmDataBinding_shouldStartUserActivity() {
        activity.findViewById(R.id.mvvm_databinding).performClick();

        Intent expectedIntent = new Intent(activity, UserActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

}
