package iview.wsienski.mvvmtrip.ui.warrior;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.base.BaseFragment;
import iview.wsienski.mvvmtrip.model.Warrior;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class WarriorFragment extends BaseFragment {

    @Inject
    WarriorViewModel mViewModel;
    private CompositeDisposable mCompositeDisposable;
    private TextView mStrengthView;
    private Spinner mWarriorsSpinner;
    private WarriorSpinnerAdapter mWarriorSpinnerAdapter;
    private EditText mEmail;
    private Button btnEmailCheck;

    public WarriorFragment() {
        // Required empty public constructor
    }

    public static WarriorFragment newInstance() {
        return new WarriorFragment();
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
        View v = inflater.inflate(R.layout.warrior_fragment, container, false);
        setupViews(v);
        bind();
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unBind();
    }

    private void setupViews(View v) {
        mWarriorsSpinner = v.findViewById(R.id.warriors);
        mStrengthView = v.findViewById(R.id.strength);
        mEmail = v.findViewById(R.id.inputEmail);
        btnEmailCheck = v.findViewById(R.id.btnEmailCheck);

        assert mWarriorsSpinner != null;
        mWarriorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view,
                                       final int position, final long id) {
                itemSelected(position);
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });
    }

    private void bind() {
        mCompositeDisposable = new CompositeDisposable();

        mCompositeDisposable.add(mViewModel.getStrength()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setStrength));

        mCompositeDisposable.add(mViewModel.getWarriors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setWarriors));

        mCompositeDisposable.add(
                RxView.clicks(btnEmailCheck)
                        .map(o -> mViewModel.checkEmail(mEmail.getText().toString()))
                        .subscribe(isCorrect -> {
                            String txt = isCorrect
                                    ? getString(R.string.email_correct)
                                    : getString(R.string.email_incorrect);
                            showToast(txt);
                        })
        );
    }

    private void unBind() {
        mCompositeDisposable.clear();
    }

    private void setStrength(final String strength) {
        assert mStrengthView != null;

        mStrengthView.setText(strength);
    }

    private void setWarriors(final List<Warrior> Warriors) {
        assert mWarriorsSpinner != null;

        mWarriorSpinnerAdapter = new WarriorSpinnerAdapter(getContext(),
                R.layout.warrior_item,
                Warriors);
        mWarriorsSpinner.setAdapter(mWarriorSpinnerAdapter);
    }

    private void itemSelected(final int position) {
        assert mWarriorSpinnerAdapter != null;

        Warrior selctedWarrior = mWarriorSpinnerAdapter.getItem(position);
        mViewModel.selectWarrior(selctedWarrior);
    }

}
