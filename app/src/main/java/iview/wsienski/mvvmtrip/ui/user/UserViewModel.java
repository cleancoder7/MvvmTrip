package iview.wsienski.mvvmtrip.ui.user;

import android.databinding.ObservableField;

import io.reactivex.disposables.CompositeDisposable;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;
import iview.wsienski.mvvmtrip.util.ResourcesUtil;
import iview.wsienski.mvvmtrip.util.Validations;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class UserViewModel {

    private final ResourcesUtil mResourcesUtil;
    private IRepository mRepository;
    private ISchedulerFacade mSchedulerFacade;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    //Output
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();
    public ObservableField<Boolean> isPremium = new ObservableField<>();
    //Input
    public ObservableField<String> email = new ObservableField<>();
    private UserFragment navigator;


    public UserViewModel(IRepository repository, ISchedulerFacade schedulerProvider, ResourcesUtil resourcesUtil) {
        this.mRepository = repository;
        this.mSchedulerFacade = schedulerProvider;
        this.mResourcesUtil = resourcesUtil;
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

    public boolean checkEmail() {
        return email != null && Validations.checkEmail(email.get());
    }

    //onclick in viewModel
    public void checkBtnOnClick() {
        String txt = checkEmail()
                ? mResourcesUtil.getString(R.string.email_correct)
                : mResourcesUtil.getString(R.string.email_incorrect);
        navigator.showToast(txt);
    }
    //onclick in viewModel
    public void setNavigator(UserFragment navigator) {
        this.navigator = navigator;
    }
}
