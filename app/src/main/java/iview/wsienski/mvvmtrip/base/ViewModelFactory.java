package iview.wsienski.mvvmtrip.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.ui.messagelive.MessageViewModel;
import iview.wsienski.mvvmtrip.schedulers.ISchedulerFacade;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    public IRepository repository;
    public ISchedulerFacade schedulerFacade;

    public ViewModelFactory(IRepository repository, ISchedulerFacade schedulerFacade) {
        this.schedulerFacade = schedulerFacade;
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MessageViewModel.class))
            return (T) new MessageViewModel(repository, schedulerFacade);
        else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
