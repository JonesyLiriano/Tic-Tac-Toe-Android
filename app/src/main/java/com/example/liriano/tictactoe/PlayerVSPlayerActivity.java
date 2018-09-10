package com.example.liriano.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PlayerVSPlayerActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int [] BUTTONS_IDS ={
            R.id.button_00,
            R.id.button_01,
            R.id.button_02,
            R.id.button_10,
            R.id.button_11,
            R.id.button_12,
            R.id.button_20,
            R.id.button_21,
            R.id.button_22,
            R.id.button_reset
    };
    Button button_00,button_01,button_02,button_10,
            button_11,button_12,button_20,button_21,
            button_22,button_reset;
    private int rondas = 0;
    private int ganadasPlayer1, ganadasPlayer2 = 0;
    TextView player1s, player2s;
    private boolean gameOver = false;
    private boolean turnoPlayer1 = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_vsplayer);
        for (int id:BUTTONS_IDS){
            findViewById(id).setOnClickListener(this);}
        button_00 = findViewById(R.id.button_00);
        button_01 = findViewById(R.id.button_01);
        button_02 = findViewById(R.id.button_02);
        button_10 = findViewById(R.id.button_10);
        button_11 = findViewById(R.id.button_11);
        button_12 = findViewById(R.id.button_12);
        button_20 = findViewById(R.id.button_20);
        button_21 = findViewById(R.id.button_21);
        button_22 = findViewById(R.id.button_22);
        button_reset = findViewById(R.id.button_reset);
        player1s = findViewById(R.id.player1_score);
        player2s = findViewById(R.id.player2_score);


    }

    private void verificarGanador() {
        if (!gameOver) {
            if (ganador()) {
                gameOver = true;
                if (!(turnoPlayer1)) {
                    player1Win();
                } else {
                    player2Win();
                }
            } else if (rondas == 9) {
                esEmpate();
            }
        }else{
            Toast.makeText(this,"Favor presione el boton de restar, juego ya terminado...", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.button_00:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_01:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }

                rondas++;
                verificarGanador();
                return;
            case R.id.button_02:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_10:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_11:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_12:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_20:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_21:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_22:
                if(!(((Button) v).getText().toString().equals(""))){
                    return;
                }else {
                    if (turnoPlayer1) {
                        ((Button) v).setText("X");
                        turnoPlayer1 = false;
                    } else {
                        ((Button) v).setText("O");
                        turnoPlayer1 = true;
                    }
                }
                rondas++;
                verificarGanador();
                return;
            case R.id.button_reset:
                button_00.setText("");
                button_01.setText("");
                button_02.setText("");
                button_10.setText("");
                button_11.setText("");
                button_12.setText("");
                button_20.setText("");
                button_21.setText("");
                button_22.setText("");
                button_00.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_01.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_02.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_10.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_11.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_12.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_20.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_21.setBackgroundResource(R.drawable.border_bottom_right_button);
                button_22.setBackgroundResource(R.drawable.border_bottom_right_button);
                turnoPlayer1 = true;
                rondas = 0;
                gameOver = false;
                return;
                default:
                    break;
        }
    }
    private boolean ganador(){

        if(button_00.getText().equals(button_01.getText())
                && button_00.getText().equals(button_02.getText())
                && !button_00.getText().equals("")){
            if(!(turnoPlayer1)){
            button_00.setBackgroundColor(Color.GREEN);
            button_01.setBackgroundColor(Color.GREEN);
            button_02.setBackgroundColor(Color.GREEN);
            }else{
                button_00.setBackgroundColor(Color.RED);
                button_01.setBackgroundColor(Color.RED);
                button_02.setBackgroundColor(Color.RED);
            }


            return true;
        }else if(button_00.getText().equals(button_10.getText())
                && button_00.getText().equals(button_20.getText())
                && !button_00.getText().equals("")){
            if(!(turnoPlayer1)) {
                button_00.setBackgroundColor(Color.GREEN);
                button_10.setBackgroundColor(Color.GREEN);
                button_20.setBackgroundColor(Color.GREEN);
            }else{
                button_00.setBackgroundColor(Color.RED);
                button_10.setBackgroundColor(Color.RED);
                button_20.setBackgroundColor(Color.RED);
                }
            return true;
        }else if(button_01.getText().equals(button_11.getText())
                && button_01.getText().equals(button_21.getText())
                && !button_01.getText().equals("")){
            if(!(turnoPlayer1)) {
                button_01.setBackgroundColor(Color.GREEN);
                button_11.setBackgroundColor(Color.GREEN);
                button_21.setBackgroundColor(Color.GREEN);
            }else{
                button_01.setBackgroundColor(Color.RED);
                button_11.setBackgroundColor(Color.RED);
                button_21.setBackgroundColor(Color.RED);
            }
            return true;
        }else if(button_02.getText().equals(button_12.getText())
                && button_02.getText().equals(button_22.getText())
                && !button_02.getText().equals("")){
            if(!(turnoPlayer1)) {
                button_02.setBackgroundColor(Color.GREEN);
                button_12.setBackgroundColor(Color.GREEN);
                button_22.setBackgroundColor(Color.GREEN);
            }else{
                button_02.setBackgroundColor(Color.RED);
                button_12.setBackgroundColor(Color.RED);
                button_22.setBackgroundColor(Color.RED);
            }
            return true;
        } else if(button_10.getText().equals(button_11.getText())
                && button_10.getText().equals(button_12.getText())
                && !button_10.getText().equals("")){
            if(!(turnoPlayer1)) {
                button_10.setBackgroundColor(Color.GREEN);
                button_11.setBackgroundColor(Color.GREEN);
                button_12.setBackgroundColor(Color.GREEN);
            }else{
                button_10.setBackgroundColor(Color.RED);
                button_11.setBackgroundColor(Color.RED);
                button_12.setBackgroundColor(Color.RED);
            }
            return true;
        }else if(button_20.getText().equals(button_21.getText())
                && button_20.getText().equals(button_22.getText())
                && !button_20.getText().equals("")){
            if(!(turnoPlayer1)) {
                button_20.setBackgroundColor(Color.GREEN);
                button_21.setBackgroundColor(Color.GREEN);
                button_22.setBackgroundColor(Color.GREEN);
            }else{
                button_20.setBackgroundColor(Color.RED);
                button_21.setBackgroundColor(Color.RED);
                button_22.setBackgroundColor(Color.RED);
            }
            return true;
        }else if(button_00.getText().equals(button_11.getText())
                && button_00.getText().equals(button_22.getText())
                && !button_00.getText().equals("")){
            if(!(turnoPlayer1)) {
                button_00.setBackgroundColor(Color.GREEN);
                button_11.setBackgroundColor(Color.GREEN);
                button_22.setBackgroundColor(Color.GREEN);
            }else{
                button_00.setBackgroundColor(Color.RED);
                button_11.setBackgroundColor(Color.RED);
                button_22.setBackgroundColor(Color.RED);
            }
            return true;
        }else if(button_02.getText().equals(button_11.getText())
                && button_02.getText().equals(button_20.getText())
                && !button_02.getText().equals("")){
            if(!(turnoPlayer1)) {
                button_02.setBackgroundColor(Color.GREEN);
                button_11.setBackgroundColor(Color.GREEN);
                button_20.setBackgroundColor(Color.GREEN);
            }else{
                button_02.setBackgroundColor(Color.RED);
                button_11.setBackgroundColor(Color.RED);
                button_20.setBackgroundColor(Color.RED);
            }
            return true;
        }else{
            return false;
        }

    }
    private void player1Win(){
        Toast.makeText(this,"Jugador 1 gano!!!", Toast.LENGTH_SHORT).show();
        ganadasPlayer1++;
        player1s.setText(String.valueOf(ganadasPlayer1));


    }
    private void player2Win(){
        Toast.makeText(this,"Jugador 2 gano!!!", Toast.LENGTH_SHORT).show();
        ganadasPlayer2++;
        player2s.setText(String.valueOf(ganadasPlayer2));
    }
    private void esEmpate(){
        Toast.makeText(this,"Es un empate!!!", Toast.LENGTH_SHORT).show();
    }
}
