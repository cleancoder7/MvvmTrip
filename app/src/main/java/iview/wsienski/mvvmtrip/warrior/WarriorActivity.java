package iview.wsienski.mvvmtrip.warrior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.model.Warrior;

public class WarriorActivity extends AppCompatActivity {

    private CompositeDisposable mCompositeDisposable;

    private WarriorViewModel mViewModel;

    private TextView mStrengthView;
    private Spinner mWarriorsSpinner;
    private WarriorSpinnerAdapter mWarriorSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warrior_activity);

        mViewModel = getViewModel();
        setupViews();
    }

    private void setupViews() {
        mWarriorsSpinner = findViewById(R.id.warriors);
        mStrengthView = findViewById(R.id.strength);
        
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

    @Override
    protected void onResume() {
        super.onResume();
        bind();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unBind();
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

        mWarriorSpinnerAdapter = new WarriorSpinnerAdapter(this,
                R.layout.warrior_item,
                Warriors);
        mWarriorsSpinner.setAdapter(mWarriorSpinnerAdapter);
    }


    private WarriorViewModel getViewModel() {
        return ((MyApplication) getApplication()).getViewModel();
    }

    private void itemSelected(final int position) {
        assert mWarriorSpinnerAdapter != null;

        Warrior selctedWarrior = mWarriorSpinnerAdapter.getItem(position);
        mViewModel.selectWarrior(selctedWarrior);
    }
}
