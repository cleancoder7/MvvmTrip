package iview.wsienski.mvvmtrip.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public interface ISchedulerFacade {

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

    @NonNull
    Scheduler computation();

}
