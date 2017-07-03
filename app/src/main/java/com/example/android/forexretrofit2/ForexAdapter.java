package com.example.android.forexretrofit2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.forexretrofit2.data.model.ForexResponse;

import java.util.List;

/**
 * Created by Nissan on 7/2/2017.
 */

public class ForexAdapter extends ArrayAdapter<ForexResponse> {
    public ForexAdapter(@NonNull Context context, @NonNull List<ForexResponse> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        ForexResponse forexResponse = getItem(position);
        TextView nameView = (TextView)listItemView.findViewById(R.id.name);
        TextView buyingView = (TextView)listItemView.findViewById(R.id.buying_rate);
        TextView sellingView = (TextView)listItemView.findViewById(R.id.selling_rate);

        nameView.setText(forexResponse.getName());
        buyingView.setText(forexResponse.getBuyingRate());
        sellingView.setText(forexResponse.getSellingRate());


        return listItemView;
    }
}
