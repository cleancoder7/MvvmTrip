package iview.wsienski.mvvmtrip.ui.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.internal.operators.observable.ObservableScan;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.model.User;
import iview.wsienski.mvvmtrip.schedulers.TestScheduler;
import iview.wsienski.mvvmtrip.util.ResourcesUtil;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Witold Sienski on 11.12.2017.
 */

public class UserViewModelTest {

    @Mock
    private IRepository mModel;
    @Mock
    private IUserNavigator userNavigator;
    @Mock
    private ResourcesUtil resourcesUtil;

    private UserViewModel userViewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userViewModel = new UserViewModel(mModel, new TestScheduler(), resourcesUtil);
        userViewModel.setNavigator(userNavigator);
    }

    @Test
    public void showError_ifEmailIsNotValid() {
        userViewModel.email.set("test");
        Mockito.when(resourcesUtil.getString(R.string.email_correct))
                .thenReturn("email_correct");
        Mockito.when(resourcesUtil.getString(R.string.email_incorrect))
                .thenReturn("email_incorrect");

        userViewModel.checkBtnOnClick();

        verify(userNavigator).showToast("email_incorrect");
    }

    @Test
    public void showOk_ifEmailIsValid() {
        userViewModel.email.set("test@test.pl");
        Mockito.when(resourcesUtil.getString(R.string.email_correct))
                .thenReturn("email_correct");
        Mockito.when(resourcesUtil.getString(R.string.email_incorrect))
                .thenReturn("email_incorrect");

        userViewModel.checkBtnOnClick();

        verify(userNavigator).showToast("email_correct");
    }

    @Test
    public void userNameValid_ifUserSet() {
        when(mModel.getUser()).thenReturn(
                ObservableScan.just(new User("test", 21, false))
        );

        userViewModel.loadUser();

        Assert.assertTrue(userViewModel.name.get().equals("test"));
    }

    @Test
    public void userAgeValid_ifUserSet() {
        when(mModel.getUser()).thenReturn(
                ObservableScan.just(new User("test", 21, false))
        );

        userViewModel.loadUser();

        Assert.assertTrue(userViewModel.age.get().equals("21"));
    }

    @Test
    public void userPremiumValid_ifUserSet() {
        when(mModel.getUser()).thenReturn(
                ObservableScan.just(new User("test", 21, false))
        );

        userViewModel.loadUser();

        Assert.assertTrue(userViewModel.isPremium.get().equals(false));
    }

}
