package iview.wsienski.mvvmtrip.messagelive;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseFragment;
import iview.wsienski.mvvmtrip.base.ViewModelFactory;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class MessageFragment extends BaseFragment {

    @Inject
    ViewModelFactory viewModelFactory;

    MessageViewModel messageViewModel;

    TextView title, message;

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

        messageViewModel.getMessageLiveData().observe(this, message -> {
            Timber.d("View get msg %s", message.getTitle());
            setTitle(message.getTitle());
            setMessageDesc(message.getMessage());
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.message_fragment, container, false);
        title = v.findViewById(R.id.title);
        message = v.findViewById(R.id.message);
        return v;
    }

    public void setTitle(String txt) {
        title.setText(txt);
    }

    public void setMessageDesc(String txt) {
        message.setText(txt);
    }
}
