package iview.wsienski.mvvmtrip;

import android.app.Application;

import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.datamodel.Repository;
import iview.wsienski.mvvmtrip.di.compontent.AppComponent;
import iview.wsienski.mvvmtrip.di.compontent.DaggerAppComponent;
import iview.wsienski.mvvmtrip.di.module.AppModule;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerProvider;
import iview.wsienski.mvvmtrip.schedulers.SchedulerProvider;
import iview.wsienski.mvvmtrip.warrior.WarriorViewModel;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;

    private final IRepository model;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

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

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
