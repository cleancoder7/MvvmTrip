package iview.wsienski.mvvmtrip.di.compontent;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.di.module.AppModule;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Singleton
@Component(modules = {
        AppModule.class})
public interface AppComponent {

    void inject(MyApplication app);

    SharedPreferences sharedPreferences();
}
