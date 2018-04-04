package com.simcoder.tinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * Author: 		INVent.
 * Instructor: 	Faith-Michael Uzoka
 * Course: 		COMP 2633
 * E-mails: 	vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date: 		April 3rd 2018
 * Purpose:
 * 		- The user discarded list of products
 * Details:
 * 		- It adds elements whenever the user right or left swipe them,
 * 	   	  creating a list of discarded products, similar to a history list. More implementation to be done.
 */


public class DiscardedActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> discList = new ArrayList<String>();

    @Override
    /**
     * Adds test elements into the discList of the class
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discarded);

        listView = (ListView) findViewById(R.id.discarded_list);

        String[] values = new String[]{
                "Logitech G502",
                "Microsoft Surface Pro(5th Gen)",
                "SteelSeries Apex M750",
                "HP Envy x360"
        };

        for (int i = 0; i < values.length; i++)
            discList.add(values[i]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, discList);
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
