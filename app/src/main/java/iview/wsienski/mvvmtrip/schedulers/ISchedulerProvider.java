package iview.wsienski.mvvmtrip.schedulers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public interface ISchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler ui();

}
