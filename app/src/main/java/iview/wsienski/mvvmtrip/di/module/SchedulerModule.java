package iview.wsienski.mvvmtrip.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;
import iview.wsienski.mvvmtrip.schedulers.SchedulerFacade;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Module
public class SchedulerModule {

    @Provides
    @Singleton
    ISchedulerFacade provideScheduler() {
        return SchedulerFacade.getInstance();
    }
}
