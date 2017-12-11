package iview.wsienski.mvvmtrip.ui.menu;

import android.content.Intent;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.ui.user.UserActivity;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Witold Sienski on 11.12.2017.
 */
@RunWith(RobolectricTestRunner.class)
public class MenuActivityTest {

    @MediumTest
    @Test
    public void clickingMvvmDataBinding_shouldStartUserActivity() {
        MenuActivity activity = Robolectric.setupActivity(MenuActivity.class);
        activity.findViewById(R.id.mvvm_databinding).performClick();

        Intent expectedIntent = new Intent(activity, UserActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

}
