package com.simcoder.tinder;

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

        //Picasso.with(getApplicationContext()).load(keyboard_img[0]).into(ivImage);


        arrAdapterCards = new ArrayAdapter<Product>(this, R.layout.item, R.id.name, prods );
        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.name, al );


        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
                // cards.remove(0);
                // arrAdapterCards.notifyDataSetChanged();
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
                    fActivity.add((Product) dataObject);


                Toast.makeText(MainActivity.this, "Added to Favourites", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
               // al.add("XML ".concat(String.valueOf(i)));
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
