package com.example.liriano.tictactoe;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.graphics.drawable.AnimationDrawable;

public class SplashActivity extends AppCompatActivity {
    AnimationDrawable animacionGifSplash;
    ImageView imageViewGifSplash;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //animacion del splash
        imageViewGifSplash = findViewById(R.id.imageViewGifSplash);
        imageViewGifSplash.setBackgroundResource(R.drawable.splash_activity_gif_animation);
        animacionGifSplash = (AnimationDrawable) imageViewGifSplash.getBackground();
        intent = new Intent(this, MainActivity.class);
        //alpha animacion
        Animation transition = AnimationUtils.loadAnimation(this,R.anim.transition);
        imageViewGifSplash.startAnimation(transition);

    }

    @Override
    protected void onStart() {
        super.onStart();
        animacionGifSplash.start();
        Thread timer = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(5*1000);

                    startActivity(intent);
                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        timer.start();
    }
}
