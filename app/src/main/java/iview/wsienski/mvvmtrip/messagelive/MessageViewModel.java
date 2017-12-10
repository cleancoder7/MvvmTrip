package iview.wsienski.mvvmtrip.messagelive;

import android.arch.lifecycle.MutableLiveData;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import iview.wsienski.mvvmtrip.base.BaseViewModel;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.model.Message;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class MessageViewModel extends BaseViewModel {

    IRepository mRepository;

    MutableLiveData<Message> messageLiveData;

    public MessageViewModel(IRepository repository) {
        Timber.d("MessageViewModel");
        this.mRepository = repository;
        messageLiveData = new MutableLiveData<>();
        getMessage();
    }

    public MutableLiveData<Message> getMessageLiveData() {
        return messageLiveData;
    }

    public void getMessage() {
        getCompositeDisposable().add(mRepository.getMessage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        message -> {
                            Timber.d("get msg " + message.getTitle());
                            messageLiveData.setValue(message);
                        }
                )
        );
    }
}
