package iview.wsienski.mvvmtrip.messagelive;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.ViewModelFactory;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class MessageFragment extends Fragment {

    @Inject
    ViewModelFactory viewModelFactory;

    MessageViewModel messageViewModel;

    public MessageFragment() {
        // Required empty public constructor
    }

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ((MyApplication) getActivity().getApplication())
                .getAppComponent()
                .inject(this);
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set up and subscribe (observe) to the ViewModel
        messageViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MessageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.message_fragment, container, false);
        return v;
    }
}
