package com.simcoder.tinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by natha on 3/30/2018.
 */

public class arrayAdapter extends ArrayAdapter<Cards>{
    Context context;
    public arrayAdapter(Context context, int resourceID, List<Cards> items){
        Super(context, resourceID, items);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Cards cardsItem = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        name.setText(cardsItem.getName());
        image.setImageResource(R.mipmap.ic_launcher);

        return convertView;
    }

}
