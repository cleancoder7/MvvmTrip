package iview.wsienski.mvvmtrip.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerProvider;
import iview.wsienski.mvvmtrip.schedulers.SchedulerProvider;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Module
public class SchedulerModule {

    @Provides
    @Singleton
    ISchedulerProvider provideScheduler() {
        return SchedulerProvider.getInstance();
    }
}
