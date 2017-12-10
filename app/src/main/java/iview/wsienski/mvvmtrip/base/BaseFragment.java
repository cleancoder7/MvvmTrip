package iview.wsienski.mvvmtrip.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class BaseFragment extends Fragment {

    public void showToast(String txt) {
        Toast.makeText(getContext(), txt, Toast.LENGTH_SHORT).show();
    }

}
