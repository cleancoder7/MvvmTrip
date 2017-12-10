package iview.wsienski.mvvmtrip.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class BaseViewModel extends ViewModel {

    private CompositeDisposable mCompositeDisposable;


    public BaseViewModel() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
