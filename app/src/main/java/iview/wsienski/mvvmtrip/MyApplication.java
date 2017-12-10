package iview.wsienski.mvvmtrip;

import android.app.Application;

import iview.wsienski.mvvmtrip.di.compontent.AppComponent;
import iview.wsienski.mvvmtrip.di.compontent.DaggerAppComponent;
import iview.wsienski.mvvmtrip.di.module.AppModule;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
