package com.simcoder.tinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayAdapter<Cards> arrAdapterCards;
    private ArrayList<Cards> cards = new ArrayList<>();
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add the view via xml or programmatically
        al = new ArrayList<>();
        al.add("Product 1");
        al.add("Product 2");
        al.add("Product 3");
        al.add("Product 4");
        al.add("Product 5");
        al.add("Product 6");
        al.add("Product 7");
        al.add("Product 8");

        cards.add(new Cards("123","123"));
        cards.add(new Cards("345","345"));

        arrAdapterCards = new ArrayAdapter<Cards>(this, R.layout.item, R.id.name, cards );
        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.name, al );


        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrAdapterCards);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                cards.remove(0);
                arrAdapterCards.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject

                // TODO: add to discarded list


                Toast.makeText(MainActivity.this, "Discarded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                // TODO: add to favourites list


                Toast.makeText(MainActivity.this, "Added to Favourites", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(MainActivity.this, "Item Clicked", Toast.LENGTH_SHORT).show();
                // move to a new activity (summary) and show all object properties
                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                startActivity(intent);
                //finish();
                return;
            }
        });

    }
}