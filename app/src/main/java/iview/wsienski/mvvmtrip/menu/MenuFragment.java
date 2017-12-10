package iview.wsienski.mvvmtrip.menu;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseFragment;
import iview.wsienski.mvvmtrip.databinding.MenuFragmentBinding;
import iview.wsienski.mvvmtrip.messagelive.MessageLiveActivity;
import iview.wsienski.mvvmtrip.user.UserActivity;
import iview.wsienski.mvvmtrip.warrior.WarriorActivity;
import timber.log.Timber;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class MenuFragment extends BaseFragment implements Navigator {
    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MenuFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.menu_fragment, container, false);

        binding.setNaviagtor(this);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.d("Hello...");
    }

    @Override
    public void goToMvvmRxJava(View view) {
        startActivity(new Intent(getContext(), WarriorActivity.class));
    }

    @Override
    public void gotToMvvmLiveData(View view) {
        startActivity(new Intent(getContext(), MessageLiveActivity.class));
    }

    @Override
    public void gotToMvvmDataBinding(View view) {
        startActivity(new Intent(getContext(), UserActivity.class));
    }
}
