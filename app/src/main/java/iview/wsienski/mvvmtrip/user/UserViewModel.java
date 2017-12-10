package iview.wsienski.mvvmtrip.user;

import android.databinding.ObservableField;

import io.reactivex.disposables.CompositeDisposable;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class UserViewModel {

    private IRepository mRepository;
    private ISchedulerFacade mSchedulerFacade;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();
    public ObservableField<String> isPremium = new ObservableField<>();


    public UserViewModel(IRepository repository, ISchedulerFacade schedulerProvider) {
        this.mRepository = repository;
        this.mSchedulerFacade = schedulerProvider;
        loadUser();
    }

    private void loadUser() {
        mCompositeDisposable.add(
                mRepository.getUser()
                        .subscribeOn(mSchedulerFacade.io())
                        .observeOn(mSchedulerFacade.ui())
                        .subscribe(
                                user -> {
                                    Timber.d("get user " + user.getName());
                                    name.set(user.getName());
                                    age.set(String.valueOf(user.getAge()));
                                    isPremium.set(user.isPremium() ? "Premium Account" : "Normal Account");
                                }
                        )
        );
    }

    public void unBind() {
        mCompositeDisposable.clear();
    }

}
