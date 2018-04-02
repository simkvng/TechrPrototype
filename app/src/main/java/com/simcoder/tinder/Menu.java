package com.simcoder.tinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button mBrowse, mFavourites, mDiscarded;
    public FavoritesList favList = new FavoritesList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mBrowse = (Button) findViewById(R.id.browse);
        mFavourites = (Button) findViewById(R.id.favourites);
        mDiscarded = (Button) findViewById(R.id.discarded);

        mBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
                //finish();
                return;
            }
        });

        mFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, FavouritesActivity.class);
                startActivity(intent);
                //finish();
                return;
            }
        });

        mDiscarded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, DiscardedActivity.class);
                startActivity(intent);
                //finish();
                return;
            }
        });
    }
}
