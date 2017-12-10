package iview.wsienski.mvvmtrip.user;

import android.databinding.ObservableField;
import android.text.TextUtils;

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
    public ObservableField<Boolean> isPremium = new ObservableField<>();
    public ObservableField<String> email = new ObservableField<>();


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
                                    isPremium.set(user.isPremium());
                                }
                        )
        );
    }

    public void unBind() {
        mCompositeDisposable.clear();
    }

    public void checkEmail() {
        if (email == null || TextUtils.isEmpty(email.get()) || !email.get().contains("@"))
            Timber.d("Email is INCORRECT");
        else
            Timber.d("Email is OK");
    }

}
