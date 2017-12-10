package iview.wsienski.mvvmtrip.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class TestScheduler implements ISchedulerFacade {

    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }


    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }
}
