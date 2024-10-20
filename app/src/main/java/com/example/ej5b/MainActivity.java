package com.example.ej5b;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imgDado;
    Button bLanzar;
    int jugador;
    int contadorRonda;
    TextView contRonda;
    View fJug1;
    View fJug2;

    TextView textJug1;
    TextView textJug2;
    int contJug1;
    int contJug2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imgDado = findViewById(R.id.iDado);
        bLanzar = findViewById(R.id.bLanzar);
        fJug1 = findViewById(R.id.vJug1);
        fJug2 = findViewById(R.id.vJug2);
        fJug1.setBackgroundColor(Color.parseColor("#21911B"));
        jugador = 1;
        contRonda = findViewById(R.id.puntosActuales);

        textJug1 = findViewById(R.id.puntosJug1);
        textJug2 = findViewById(R.id.puntosJug2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void nuevoJuego(View view) {
        contadorRonda = 0;
        contJug1 = 0;
        contJug2 = 0;

        textJug1.setText(contJug1 + "");
        textJug2.setText(contJug2 + "");
        contRonda.setText(contadorRonda + "");


    }

    public void pasarTurno(View view) {
        if (jugador == 1) {
            jugador = 2;
            contJug1 = contJug1 + contadorRonda;
            textJug1.setText(contJug1 + "");
            fJug2.setBackgroundColor(Color.parseColor("#21911B"));
            fJug1.setBackgroundColor(Color.parseColor("#939393"));
            contadorRonda = 0;
            contRonda.setText(contadorRonda + "");
        } else {
            jugador = 1;
            contJug2 = contJug2 + contadorRonda;
            textJug2.setText(contJug2 + "");
            fJug1.setBackgroundColor(Color.parseColor("#21911B"));
            fJug2.setBackgroundColor(Color.parseColor("#939393"));
            contadorRonda = 0;
            contRonda.setText(contadorRonda + "");
        }

        if (contJug1 >= 100) {
            contRonda.setText("FELICIDADES JUGADOR 1 HA GANADO");
        } else if (contJug2 >= 100) {
            contRonda.setText("FELICIDADES JUGADOR 2 HA GANADO");
        }
    }


    public void lanzarDado(View view) {
        int numeroAleatorio = (int) (Math.random() * 6) + 1;
        lanzarDado(numeroAleatorio);

        contadorRonda = contadorRonda + numeroAleatorio;
        if (numeroAleatorio == 1) {
            contadorRonda = 0;
            if (jugador == 1) {
                jugador = 2;
                fJug2.setBackgroundColor(Color.parseColor("#21911B"));
                fJug1.setBackgroundColor(Color.parseColor("#939393"));
            } else {
                jugador = 1;
                fJug1.setBackgroundColor(Color.parseColor("#21911B"));
                fJug2.setBackgroundColor(Color.parseColor("#939393"));
            }
        }

        contRonda.setText(contadorRonda + "");


    }


    public void lanzarDado(int numDado) {
        switch (numDado) {
            case 1:
                imgDado.setImageResource(R.drawable.dice_one);
                break;
            case 2:
                imgDado.setImageResource(R.drawable.dice_two);
                break;
            case 3:
                imgDado.setImageResource(R.drawable.dice_three);
                break;
            case 4:
                imgDado.setImageResource(R.drawable.dice_four);
                break;
            case 5:
                imgDado.setImageResource(R.drawable.dice_five);
                break;
            case 6:
                imgDado.setImageResource(R.drawable.dice_six);
                break;

        }
    }
}