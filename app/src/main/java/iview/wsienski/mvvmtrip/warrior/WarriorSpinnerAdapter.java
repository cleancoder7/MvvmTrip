package iview.wsienski.mvvmtrip.warrior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.model.Warrior;

/**
 * Created by Witold Sienski on 09.12.2017.
 */

public class WarriorSpinnerAdapter extends ArrayAdapter<Warrior> {

    public WarriorSpinnerAdapter(final Context context, final int resource,
                                 final List<Warrior> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView);
    }

    private View getCustomView(final int position, final View convertView) {
        ViewHolder holder;
        View view = convertView;

        if (view == null) {
            view = inflateView();
            TextView textView = view.findViewById(R.id.warrior_name);
            holder = new ViewHolder(textView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Warrior language = getItem(position);
        holder.bind(language.getName());

        return view;
    }

    private View inflateView() {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.warrior_item, null);
    }

    private class ViewHolder {

        private final TextView mText;

        public ViewHolder(final TextView text) {
            mText = text;
        }

        public void bind(final String text) {
            mText.setText(text);
        }
    }

}
