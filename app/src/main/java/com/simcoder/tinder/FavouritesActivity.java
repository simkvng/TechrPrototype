package com.simcoder.tinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;


public class FavouritesActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> favList = new ArrayList<String>();

    public ArrayList<String> getFavList()
    {
        return favList;
    }

    public void setFavList()
    {
        this.favList = favList;
    }
    public void add(Product prod)
    {
        favList.add(prod.getName());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        listView = (ListView) findViewById(R.id.favourites_list);

        String[] values = new String[]{
                "SteelSeries Apex M750",
                "Microsoft Surface Pro(5th Gen)",
                "Logitech G502"
        };

        for (int i = 0; i < values.length; i++)
            favList.add(values[i]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, favList);
        listView.setAdapter(adapter);
/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index


                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+position+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });
*/
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
