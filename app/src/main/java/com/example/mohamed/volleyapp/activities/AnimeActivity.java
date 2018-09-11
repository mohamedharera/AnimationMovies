package com.example.mohamed.volleyapp.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mohamed.volleyapp.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        getSupportActionBar().hide();

        // recieve data

        String anime_name = getIntent().getExtras().getString("anime_name");
        String anime_description = getIntent().getExtras().getString("anime_description");
        String anime_studio = getIntent().getExtras().getString("anime_studio");
        String anime_category = getIntent().getExtras().getString("anime_category");
        String anime_img = getIntent().getExtras().getString("anime_img");
        String anime_rating = getIntent().getExtras().getString("anime_rating");
        int anime_eposide = getIntent().getExtras().getInt("anime_epsiode");

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = (TextView) (TextView) findViewById(R.id.aa_anime_name);
        TextView tv_studio
                = (TextView) findViewById(R.id.aa_studio);
        TextView tv_category = (TextView) findViewById(R.id.aa_category);
        TextView tv_description = (TextView) findViewById(R.id.aa_description);
        TextView tv_rating = (TextView) findViewById(R.id.aa_rating);
        ImageView tv_img = (ImageView) findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_name.setText(anime_name);
        tv_studio.setText(anime_studio);
        tv_category.setText(anime_category);
        tv_description.setText(anime_description);
        tv_rating.setText(anime_rating);
        collapsingToolbarLayout.setTitle(anime_name);


        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

        Glide.with(this).load(anime_img).apply(options).into(tv_img);

    }
}
