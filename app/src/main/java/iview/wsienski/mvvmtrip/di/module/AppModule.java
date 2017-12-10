package iview.wsienski.mvvmtrip.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.util.ResourcesUtil;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Module
public class AppModule {

    MyApplication mApplication;

    public AppModule(MyApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplication() {
        return mApplication;
    }

    @Provides
    Context provideContext(MyApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(MyApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    ResourcesUtil provideResourcesUtil(MyApplication application) {
        return new ResourcesUtil(application);
    }
}
