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
 * Author:       INVent.
 * Instructor:   Faith-Michael Uzoka
 * Course:       COMP 2633
 * E-mails:      vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date:         April 3rd 2018
 * Purpose:
 *     - arrayAdapter class is used for being able to display an ArrayList of products in many different views.
 */

public class arrayAdapter extends ArrayAdapter<Product>{
    Context context;
    public arrayAdapter(Context context, int resourceID, List<Product> items){
        super(context, resourceID, items);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Product productItem = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        ImageView picView = (ImageView) convertView.findViewById(R.id.productPic);
        name.setText(productItem.getName());
        image.setImageResource(R.mipmap.ic_launcher);

        return convertView;
    }

}
