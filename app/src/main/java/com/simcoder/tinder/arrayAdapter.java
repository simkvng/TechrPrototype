package com.simcoder.tinder;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

/**
 * Created by natha on 3/30/2018.
 */

public class arrayAdapter extends ArrayAdapter<Cards>{
    Context context;
    public_arrayAdapter(Context context, int resourceID, List<Cards> items){
        super(context, resourceID, items);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Cards cardsItem = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        name.setTExt(cardsItem.getName());
        image.setImageResource(R.mipmap.ic_launcher);

        return convertView;
    }

}
