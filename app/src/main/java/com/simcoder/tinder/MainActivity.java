package com.simcoder.tinder;

/**
 * Author:       INVent.
 * Instructor:   Faith-Michael Uzoka
 * Course:       COMP 2633
 * E-mails:      vmend664@mtroyal.ca, nchua235@mtroyal.ca, ipiet870@mtroyal.ca
 * Date:         April 3rd 2018
 * Purpose:
 *     - Main Activity provides all functionalities for when a user is on the browsing interface.
 * Details:
 *     - handles the swipe-cards feature (swiping left and right) and adds a product to their
 *       respective lists.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayAdapter<Product> arrAdapterCards;
    private FavoritesList fList = new FavoritesList();
    private FavouritesActivity fActivity = new FavouritesActivity();
    private ArrayList<Product> prods = new ArrayList<>();
    private int i;

    //ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //add the view via xml or programmatically


        //test adding

        String [] keyboard_img = {"https://media.memoryexpress.com/Images/Products/MX68010/0?Size=Default","https://media.memoryexpress.com/Images/Products/MX68010/1?Size=Default"};
        String [] laptop_img = {"https://media.memoryexpress.com/Images/Products/MX67320/0?Size=Default","https://media.memoryexpress.com/Images/Products/MX67320/1?Size=Default"};
        prods.add(new Product("HP Envy x360", "Laptop", new String[]{"Keyboard", "Gaming"}, 799.99, keyboard_img, 4.6, "url2"));
        prods.add(new Product("SteelSeries Apex M750", "Keyboard", new String[]{"Keyboard", "Gaming"}, 799.99, keyboard_img, 4.6, "url2"));
        prods.add(new Product("Microsoft Surface Pro(5th Gen)", "Laptop", new String[]{"Laptop", "Office"}, 699.99, laptop_img, 2.6, "url2"));
        prods.add(new Product("Logitech G502", "Mouse", new String[]{"Laptop", "Office"}, 699.99, laptop_img, 2.6, "url2"));

        al = new ArrayList<>();
        al.add(prods.get(0).getName());
        al.add(prods.get(1).getName());
        al.add(prods.get(2).getName());
        al.add(prods.get(3).getName());

        arrAdapterCards = new ArrayAdapter<>(this, R.layout.item, R.id.name, prods );

        //Picasso.with(getApplicationContext()).load(keyboard_img[0]).into(ivImage); <-- used to load product images on card; currently not working.


        arrAdapterCards = new ArrayAdapter<Product>(this, R.layout.item, R.id.name, prods );
        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.name, al );


        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
                // cards.remove(0);
                // arrAdapterCards.notifyDataSetChanged();
            }

            /** executes the function body off a left swipe by the user.
             * @param dataObject - the object to be swiped
             */
            @Override
            public void onLeftCardExit(Object dataObject) {

                Toast.makeText(MainActivity.this, "Discarded", Toast.LENGTH_SHORT).show();
            }

            /** executes the function body off a right swipe by the user.
              * @param dataObject - the object to be swiped
              */
            @Override
            public void onRightCardExit(Object dataObject) {

                    fActivity.add((Product) dataObject);


                Toast.makeText(MainActivity.this, "Added to Favourites", Toast.LENGTH_SHORT).show();
            }

            /** executes the function body when their are no more products to display on the screen.
             * @param itemsInAdapter - number of items remaining in the arrayAdapter
             */
            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

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
                Intent intent = new Intent(MainActivity.this, FavouritesActivity.class);
                startActivity(intent);
                //finish();
                return;
            }
        });

    }
}
