package iview.wsienski.mvvmtrip.ui.messagelive;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import iview.wsienski.mvvmtrip.base.BaseViewModel;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.model.Message;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;
import iview.wsienski.mvvmtrip.util.Validations;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
//LiveData
public class MessageViewModel extends BaseViewModel {

    private IRepository mRepository;
    private ISchedulerFacade mSchedulerFacade;

    private MutableLiveData<Message> messageLiveData;

    public MessageViewModel(IRepository repository, ISchedulerFacade iSchedulerFacade) {
        Timber.d("create");
        this.mRepository = repository;
        this.mSchedulerFacade = iSchedulerFacade;

        messageLiveData = new MutableLiveData<>();
        loadMessage();
    }

    public LiveData<Message> getMessageLiveData() {
        return messageLiveData;
    }

    public void loadMessage() {
        getCompositeDisposable().add(mRepository.getMessage()
                .subscribeOn(mSchedulerFacade.io())
                .observeOn(mSchedulerFacade.ui())
                .subscribe(
                        message -> {
                            Timber.d("get msg " + message.getTitle());
                            messageLiveData.setValue(message);
                        }
                )
        );
    }

    public boolean checkEmail(String email) {
        return Validations.checkEmail(email);
    }
}
