package iview.wsienski.mvvmtrip.ui.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseFragment;
import iview.wsienski.mvvmtrip.databinding.UserFragmentBinding;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class UserFragment extends BaseFragment implements UserNavigator {

    @Inject
    UserViewModel mViewModel;

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ((MyApplication) getActivity().getApplication())
                .getAppComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UserFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.user_fragment, container, false);

        binding.setViewModel(mViewModel);
        //onclick in View
        binding.setNavigator(this);
        //onclick in ViewModel
        mViewModel.setNavigator(this);
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewModel.unBind();
    }

    @Override
    public void checkBtnOnClick() {
        String txt = mViewModel.checkEmail()
                ? getString(R.string.email_correct)
                : getString(R.string.email_incorrect);
        showToast(txt);
    }
}
