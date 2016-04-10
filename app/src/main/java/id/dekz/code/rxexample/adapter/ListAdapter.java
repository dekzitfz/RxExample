package id.dekz.code.rxexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import id.dekz.code.rxexample.R;

/**
 * Created by DEKZ on 4/10/2016.
 */
public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<String> items;
    private LayoutInflater inflater;

    public ListAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.row_list, null);

        TextView tvrowlist = (TextView) convertView.findViewById(R.id.tvRowList);

        String item = items.get(position);
        tvrowlist.setText(item);

        return convertView;
    }
}
