package iview.wsienski.mvvmtrip.di.compontent;

import javax.inject.Singleton;

import dagger.Component;
import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.di.module.AppModule;
import iview.wsienski.mvvmtrip.di.module.RepositoryModule;
import iview.wsienski.mvvmtrip.di.module.SchedulerModule;
import iview.wsienski.mvvmtrip.di.module.ViewModelModule;
import iview.wsienski.mvvmtrip.messagelive.MessageFragment;
import iview.wsienski.mvvmtrip.warrior.WarriorActivity;
import iview.wsienski.mvvmtrip.warrior.WarriorFragment;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        RepositoryModule.class,
        SchedulerModule.class,
        ViewModelModule.class})
public interface AppComponent {

    void inject(MyApplication app);
    void inject(WarriorActivity warriorActivity);

    void inject(WarriorFragment warriorFragment);

    void inject(MessageFragment messageFragment);
}
