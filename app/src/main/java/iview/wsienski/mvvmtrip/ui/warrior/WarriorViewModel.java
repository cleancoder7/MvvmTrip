package iview.wsienski.mvvmtrip.ui.warrior;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.model.Warrior;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;
import iview.wsienski.mvvmtrip.util.Validations;

/**
 * Created by Witold Sienski on 09.12.2017.
 */
//RxJava&RxBinding
public class WarriorViewModel {

    private final IRepository mModel;

    private final BehaviorSubject<Warrior> mWarrior = BehaviorSubject.create();

    private final ISchedulerFacade mSchedulerProvider;

    public WarriorViewModel(final IRepository model,
                            final ISchedulerFacade schedulerProvider) {
        mModel = model;
        mSchedulerProvider = schedulerProvider;
    }


    public Observable<String> getStrength() {
        return mWarrior
                .observeOn(mSchedulerProvider.io())
                .map(Warrior::getmType)
                .flatMap(mModel::getWarriorStrength);
    }


    public Observable<List<Warrior>> getWarriors() {
        return mModel.getWarriorsObservable();
    }

    public void selectWarrior(final Warrior warrior) {
        mWarrior.onNext(warrior);
    }

    public boolean checkEmail(String email) {
        return Validations.checkEmail(email);
    }
}
