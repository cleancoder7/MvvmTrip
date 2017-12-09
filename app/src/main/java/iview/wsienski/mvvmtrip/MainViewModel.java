package iview.wsienski.mvvmtrip;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import iview.wsienski.mvvmtrip.datamodel.IModel;
import iview.wsienski.mvvmtrip.model.Warrior;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerProvider;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

class MainViewModel {

    private final IModel mModel;
    
    private final BehaviorSubject<Warrior> mWarriorLanguage = BehaviorSubject.create();

    private final ISchedulerProvider mSchedulerProvider;

    public MainViewModel( final IModel model,
                          final ISchedulerProvider schedulerProvider) {
        mModel = model;
        mSchedulerProvider = schedulerProvider;
    }

    
    public Observable<String> getStrength() {
        return mWarriorLanguage
                .observeOn(mSchedulerProvider.computation())
                .map(Warrior::getmType)
                .flatMap(mModel::getWarriorStrength);
    }

    
    public Observable<List<Warrior>> getWarriors() {
        return mModel.getWarriorsObservable();
    }

    public void selectWarrior(final Warrior warrior) {
        mWarriorLanguage.onNext(warrior);
    }

}
