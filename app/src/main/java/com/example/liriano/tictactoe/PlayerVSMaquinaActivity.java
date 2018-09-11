package com.example.liriano.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class PlayerVSMaquinaActivity extends AppCompatActivity implements View.OnClickListener {
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
    ImageButton button_back_activity;
    private int rondas = 0;
    private int ganadasPlayer1, ganadasPlayer2 = 0;
    TextView player1s, player2s;
    private boolean gameOver = false;
    private boolean turnoPlayer1 = true;
    private int eleccionMaquina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_vsmaquina);
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
        button_back_activity = findViewById(R.id.back_button);
        button_back_activity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_00:
                mJugada(button_00);
                return;
            case R.id.button_01:
                mJugada(button_01);
                return;
            case R.id.button_02:
                mJugada(button_02);
                return;
            case R.id.button_10:
                mJugada(button_10);
                return;
            case R.id.button_11:
                mJugada(button_11);
                return;
            case R.id.button_12:
                mJugada(button_12);
                return;
            case R.id.button_20:
                mJugada(button_20);
                return;
            case R.id.button_21:
                mJugada(button_21);
                return;
            case R.id.button_22:
                mJugada(button_22);
                return;
            case R.id.back_button:
                finish();
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
                eleccionMaquina = 0;
                return;
            default:
                break;
        }
    }

    private void mJugada(Button button) {
        if (!gameOver) {
            if (!(button.getText().toString().equals("")) && !turnoPlayer1) {
                simularMaquina();
            } else {
                if (turnoPlayer1) {
                    button.setText("X");
                    turnoPlayer1 = false;
                    rondas++;
                    if (verificarGanador()) {
                        return;
                    }
                    simularMaquina();
                } else {
                    button.setText("O");
                    turnoPlayer1 = true;
                    rondas++;
                    verificarGanador();
                }
            }
        }else{
            Toast.makeText(this,"Favor presione el boton de restar, juego ya terminado...", Toast.LENGTH_SHORT).show();
        }
    }

    private void simularMaquina(){
            eleccionMaquina = (int) (Math.random() * 9) + 1;
            switch (eleccionMaquina) {
                case 1:
                    button_00.performClick();
                    return;
                case 2:
                    button_01.performClick();
                    return;
                case 3:
                    button_02.performClick();
                    return;
                case 4:
                    button_10.performClick();
                    return;
                case 5:
                    button_11.performClick();
                    return;
                case 6:
                    button_12.performClick();
                    return;
                case 7:
                    button_20.performClick();
                    return;
                case 8:
                    button_21.performClick();
                    return;
                case 9:
                    button_22.performClick();
                    return;
                default:
                    break;
            }
        }

    private boolean verificarGanador() {
         if (ganador()) {
                gameOver = true;
                if (!(turnoPlayer1)) {
                    player1Win();
                } else {
                    MaquinaWin();
                }
                return true;
            } else if (rondas == 9) {
                gameOver = true;
                esEmpate();
                return true;
            }else {
             return false;
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
    private void MaquinaWin(){
        Toast.makeText(this,"La Maquina gano!!!", Toast.LENGTH_SHORT).show();
        ganadasPlayer2++;
        player2s.setText(String.valueOf(ganadasPlayer2));
    }
    private void esEmpate(){
        Toast.makeText(this,"Es un empate!!!", Toast.LENGTH_SHORT).show();
    }
}

