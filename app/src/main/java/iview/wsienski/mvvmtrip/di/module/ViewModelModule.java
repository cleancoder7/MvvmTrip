package iview.wsienski.mvvmtrip.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iview.wsienski.mvvmtrip.base.ViewModelFactory;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;
import iview.wsienski.mvvmtrip.user.UserViewModel;
import iview.wsienski.mvvmtrip.util.ResourcesUtil;
import iview.wsienski.mvvmtrip.warrior.WarriorViewModel;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Module
public class ViewModelModule {

    @Provides
    WarriorViewModel provideWarriorViewModel(IRepository repository, ISchedulerFacade schedulerProvider) {
        return new WarriorViewModel(repository, schedulerProvider);
    }

    @Provides
    UserViewModel provideUserViewModel(IRepository repository, ISchedulerFacade schedulerProvider, ResourcesUtil resourcesUtil) {
        return new UserViewModel(repository, schedulerProvider, resourcesUtil);
    }

    @Provides
    @Singleton
    ViewModelFactory provideViewModelFactory(IRepository repository, ISchedulerFacade schedulerFacade) {
        return new ViewModelFactory(repository, schedulerFacade);
    }

}
