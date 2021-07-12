package com.androidbatch.onlineretrofittest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class ImageDetailsActivity extends AppCompatActivity {


    TextView dt_date, dt_explaination, dt_hdurl;
    ImageView dt_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);


        dt_img = findViewById(R.id.dt_img);
        dt_date = findViewById(R.id.dt_date);
        dt_explaination = findViewById(R.id.dt_explaination);
        dt_hdurl = findViewById(R.id.dt_hdurl);

        Intent intent = new Intent();
        String date = intent.getStringExtra("date");
        String explaination = intent.getStringExtra("explaination");
        String hdurl = intent.getStringExtra("hdurl");
        String url = intent.getStringExtra("url");

        Glide.with(this)
                .load(url)
                .centerCrop()
                .into(dt_img);
        dt_date.setText(date);
        dt_explaination.setText(explaination);
        dt_hdurl.setText(hdurl);
    }
}