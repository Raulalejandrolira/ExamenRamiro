package com.example.examenramiro;

import android.renderscript.Int2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int Suma,i;
    Button Btn1, Btn2, Btn3, Btn4, Btn5, BtnRet;
    TextView ColaNum, SumaNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn1 = findViewById(R.id.boton1); Btn2 = findViewById(R.id.boton2);
        Btn3 = findViewById(R.id.boton3); Btn4 = findViewById(R.id.boton4);
        Btn5 = findViewById(R.id.boton5); BtnRet = findViewById(R.id.BotonReinicio);

        ColaNum = findViewById(R.id.Colanumeros); SumaNumeros = findViewById(R.id.SumaNumeros);

        Btn1.setOnClickListener(this); Btn2.setOnClickListener(this); Btn3.setOnClickListener(this); Btn4.setOnClickListener(this);
        Btn5.setOnClickListener(this); BtnRet.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Button Bot = (Button) v;

        if (Bot.getId() == R.id.BotonReinicio)
        {
            resetear();
        }
        else {

            Random aleatorio = new Random();
            Integer Auxiliar = aleatorio.nextInt(9) + 1;
            ColaNum.setText(String.valueOf(Auxiliar));
            Suma += Auxiliar;
            SumaNumeros.setText("" + Suma);

            Bot.setText(String.valueOf(Auxiliar));
            Bot.setEnabled(false);

            if (Suma > 21) {
                Toast.makeText(this, "Perdiste", Toast.LENGTH_SHORT).show();
                resetear();

            }

            if (verificarBotones() && Auxiliar <= 21) {
                Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                resetear();
            }

            if (Auxiliar == 21) {
                Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                resetear();
            }
        }
    }

    public boolean verificarBotones()
    {
        boolean Ver = true;

        ViewGroup vp = (ViewGroup) findViewById(R.id.contenedorbotones);
        int contbot = vp.getChildCount();
        for (int i = 0; i < contbot; i++)
        {
            View view = vp.getChildAt(i);
            if (view instanceof Button)
            {
                if (view.isEnabled())
                {
                    Ver = false;
                }
            }
        }

        return Ver;
    }

    public void resetear()
    {
        BtnRet.setEnabled(true);
        BtnRet.setVisibility(View.VISIBLE);
        Suma = 0;
        ViewGroup vp = (ViewGroup) findViewById(R.id.contenedorbotones);
        int contbot = vp.getChildCount();
        for (int i = 0; i < contbot; i++)
        {
            View view = vp.getChildAt(i);
            if (view instanceof Button)
            {
                ((Button) view).setText("");
                view.setEnabled(true);
            }
        }

    }




}

