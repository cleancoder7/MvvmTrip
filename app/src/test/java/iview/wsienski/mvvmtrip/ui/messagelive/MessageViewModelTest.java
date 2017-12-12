package iview.wsienski.mvvmtrip.ui.messagelive;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Observer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.model.Message;
import iview.wsienski.mvvmtrip.schedulers.TestScheduler;

/**
 * Created by Witold Sienski on 12.12.2017.
 */

public class MessageViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new android.arch.core.executor.testing.InstantTaskExecutorRule();
    @Mock
    private IRepository mModel;
    @Mock
    private
    Observer<Message> testObserver;
    private MessageViewModel userViewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userViewModel = new MessageViewModel(mModel, new TestScheduler());
    }

    @Test
    public void testMessages() {
        Message message = new Message("title", "desc");
        Mockito.when(mModel.getMessage()).thenReturn(Observable.just(message));

        userViewModel.loadMessage();
        userViewModel.getMessageLiveData().observeForever(testObserver);

        Assert.assertTrue(userViewModel.getMessageLiveData().getValue().equals(message));
    }
}
