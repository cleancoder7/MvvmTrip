package iview.wsienski.mvvmtrip.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class TestScheduler implements ISchedulerProvider  {

    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }


    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }
}
