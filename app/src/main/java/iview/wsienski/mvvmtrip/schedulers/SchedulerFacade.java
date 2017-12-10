package iview.wsienski.mvvmtrip.schedulers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class SchedulerFacade implements ISchedulerFacade {

    @Nullable
    private static SchedulerFacade INSTANCE;

    // Prevent direct instantiation.
    private SchedulerFacade() {
    }

    public static SchedulerFacade getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SchedulerFacade();
        }
        return INSTANCE;
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }
}