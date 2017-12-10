package iview.wsienski.mvvmtrip.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;
import iview.wsienski.mvvmtrip.warrior.WarriorViewModel;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Module
public class ViewModelModule {

    @Provides
    @Singleton
    WarriorViewModel provideWarriorViewModel(IRepository repository, ISchedulerFacade schedulerProvider) {
        return new WarriorViewModel(repository, schedulerProvider);
    }

}
