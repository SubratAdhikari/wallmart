package com.example.walmart;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {
    TextView splash_text;
    ImageView splash_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        splash_img= findViewById(R.id.img);
        splash_text= findViewById(R.id.txt);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        splash_img.startAnimation(animation);
        splash_text.startAnimation(animation);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(2000);
                Intent intent = new Intent(Splashscreen.this,Home.class);
                startActivity(intent);
            }
        });
        thread.start();
    }
}