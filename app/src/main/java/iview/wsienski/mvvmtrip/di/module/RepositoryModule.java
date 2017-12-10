package iview.wsienski.mvvmtrip.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.datamodel.Repository;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    IRepository provideRepository() {
        return new Repository();
    }
}
