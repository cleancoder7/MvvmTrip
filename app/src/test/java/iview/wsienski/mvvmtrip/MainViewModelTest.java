package iview.wsienski.mvvmtrip;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import iview.wsienski.mvvmtrip.datamodel.IModel;
import iview.wsienski.mvvmtrip.model.Warrior;
import iview.wsienski.mvvmtrip.schedulers.TestScheduler;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class MainViewModelTest {

    @Mock
    private IModel mModel;

    private MainViewModel mMainViewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mMainViewModel = new MainViewModel(mModel, new TestScheduler());
    }

    @Test
    public void testGetWarriors_doesNotEmit_whenNoWarriorSet() {
        TestObserver<String> testObserver = new TestObserver<>();
        mMainViewModel.getStrength().subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertNoValues();
    }

    @Test
    public void testGetWarriors_emitsCorrectWarriors_whenWarriorSet() {
        String strength = "Weak";
        Warrior one = new Warrior("Shield Bearer", Warrior.WarriorType.INFANTRY);
        Mockito.when(mModel.getWarriorStrength(Warrior.WarriorType.INFANTRY))
                .thenReturn(Observable.just(strength));
        TestObserver<String> testObserver = new TestObserver<>();
        mMainViewModel.getStrength().subscribe(testObserver);

        mMainViewModel.selectWarrior(one);

        testObserver.assertNoErrors();
        testObserver.assertValue(strength);
    }

    @Test
    public void testGetWarriors_emitsCorrectWarriors() {
        Warrior one = new Warrior("Shield Bearer", Warrior.WarriorType.INFANTRY);
        Warrior two = new Warrior("Hussar", Warrior.WarriorType.CAVALRY);
        List<Warrior> warriors = Arrays.asList(one, two);
        Mockito.when(mModel.getWarriorsObservable()).thenReturn(Observable.just(warriors));
        TestObserver<List<Warrior>> testObserver = new TestObserver<>();

        mMainViewModel.getWarriors().subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertValue(warriors);
    }

}
