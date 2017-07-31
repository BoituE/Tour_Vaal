package com.example.admin.tour_vaal;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 7/28/2017.
 */

public class MallList extends ArrayAdapter<Mall> {

    private Activity context;
    private List<Mall> mallList;

    public MallList(Activity context, List<Mall> mallList) {
        super(context, R.layout.listitem, mallList);
        this.context = context;
        this.mallList = mallList;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listitem, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewAddress = (TextView) listViewItem.findViewById(R.id.textViewAddress);
        Mall mall = mallList.get(position);

        textViewName.setText(mall.getMallName());
        textViewAddress.setText(mall.getMallAddress());



        return listViewItem;
    }
}
