package iview.wsienski.mvvmtrip;

import android.app.Application;

import iview.wsienski.mvvmtrip.datamodel.IModel;
import iview.wsienski.mvvmtrip.datamodel.Model;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerProvider;
import iview.wsienski.mvvmtrip.schedulers.SchedulerProvider;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class MyApplication extends Application {

    private final IModel model;

    public MyApplication() {
        model = new Model();
    }

    public IModel getModel() {
        return model;
    }

    public ISchedulerProvider getSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    public MainViewModel getViewModel() {
        return new MainViewModel(getModel(), getSchedulerProvider());
    }


}
