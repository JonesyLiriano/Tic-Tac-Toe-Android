package com.example.liriano.tictactoe;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {
    AnimationDrawable animacionGif;
    ImageView imageViewGif, imageViewPng;
    Animation zoomin, zoomout;
    ImageButton imageButtonPVP, imageButtonPVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //animacion para el gif en la portada
        imageViewGif = findViewById(R.id.gif_tic_tac_toe_portada_image_view);
        imageViewGif.setBackgroundResource(R.drawable.tic_tac_toe_portada_list);
        animacionGif = (AnimationDrawable) imageViewGif.getBackground();

        //animacion para el zoom in y zoom out de la imagen Game Modes
        imageViewPng = findViewById(R.id.png_game_modes);
        zoomin = AnimationUtils.loadAnimation(this, R.anim.animacion_zoom_in);
        zoomout = AnimationUtils.loadAnimation(this,R.anim.animacion_zoom_out);
        zoomin.setAnimationListener(this);
        zoomout.setAnimationListener(this);
        imageViewPng.setAnimation(zoomin);
        imageViewPng.setAnimation(zoomout);

        //animacion para rotar dos imagen button
        imageButtonPVP = findViewById(R.id.imageButtonPVP);
        imageButtonPVM = findViewById(R.id.imageButtonPVM);
        //Onclick Listener
        imageButtonPVP.setOnClickListener(this);
        imageButtonPVM.setOnClickListener(this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        animacionGif.start();
        imageViewPng.startAnimation(zoomin);
        imageButtonPVP.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotacion_infinita_derecha));
        imageButtonPVM.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotacion_infinita_izquierda));
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == zoomin) {
            imageViewPng.startAnimation(zoomout);
        } else if (animation == zoomout) {
            imageViewPng.startAnimation(zoomin);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageButtonPVP){
            goActivity(PlayerVSPlayerActivity.class);
        }else if(v.getId() == R.id.imageButtonPVM){
            goActivity(PlayerVSMaquinaActivity.class);
        }
    }

    private void goActivity(Class activityClass){
        startActivity(new Intent(this, activityClass));

    }
}