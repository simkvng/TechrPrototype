package com.simcoder.tinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;
/**
 * Author: 		INVent.
 * Instructor: 	Faith-Michael Uzoka
 * Course: 		COMP 2633
 * E-mails: 	vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date: 		April 3rd 2018
 * Purpose:
 * 		- The user favourite list of products
 * Details:
 * 		- Whenever the user swipes a product to the right it is added to this list. More implementation to be done.
 */


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

    /**
     * adds product to list
     * @param prod - prod to be added
     */
    public void add(Product prod)
    {
        favList.add(prod.getName());
    }
    @Override
    /**
     * Adds test elements nto the favList of the class.
     */
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

    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     *
     */
    @Override
    protected void onStop() {
        super.onStop();
    }
}
