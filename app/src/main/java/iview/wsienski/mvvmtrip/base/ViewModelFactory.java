package iview.wsienski.mvvmtrip.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import iview.wsienski.mvvmtrip.datamodel.IRepository;
import iview.wsienski.mvvmtrip.messagelive.MessageViewModel;

/**
 * Created by Witold Sienski on 10.12.2017.
 */
@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    public IRepository repository;

    public ViewModelFactory(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MessageViewModel.class))
            return (T) new MessageViewModel(repository);
        else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }
    }
}
