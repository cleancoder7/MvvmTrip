package iview.wsienski.mvvmtrip;

import android.app.Application;

import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.datamodel.Repository;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerProvider;
import iview.wsienski.mvvmtrip.schedulers.SchedulerProvider;
import iview.wsienski.mvvmtrip.warrior.WarriorViewModel;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class MyApplication extends Application {

    private final IRepository model;

    public MyApplication() {
        model = new Repository();
    }

    public IRepository getModel() {
        return model;
    }

    public ISchedulerProvider getSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    public WarriorViewModel getViewModel() {
        return new WarriorViewModel(getModel(), getSchedulerProvider());
    }


}
