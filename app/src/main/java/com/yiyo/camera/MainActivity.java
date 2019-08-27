package com.yiyo.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable run;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        final ImageView imv = findViewById(R.id.imv);
        run = new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "http://:8080/img.png";
//                    Bitmap bmp = null;
//                    InputStream in = new java.net.URL(url).openStream();
//                    bmp = BitmapFactory.decodeStream(in);
//                    imv.setImageBitmap(bmp);
                    System.out.println(imv);
//                    Picasso..load("https://golang.org/lib/godoc/images/home-gopher.png").into(imv);
                    PicassoTrustAll.getInstance(getApplicationContext()).load(url).into(imv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.postDelayed(this, 200);
            }
        };
        handler.post(run);

    }
}
