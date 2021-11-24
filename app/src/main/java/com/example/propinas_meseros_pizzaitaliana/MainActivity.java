package com.example.propinas_meseros_pizzaitaliana;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // ----------------------------------
    // Atributos
    // ----------------------------------
    private EditText porPizzeria, porMesero, porCocina, cantMesero, cantCocina, valorPropina;
    private TextView resPizzeria, resMesero, resCocina;

    // ----------------------------------
    // Constructor
    // ----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Colocar icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.logoappfond);

        // Inicializando ariables
        porPizzeria = (EditText)findViewById(R.id.editTextNumber);
        porCocina = (EditText)findViewById(R.id.editTextNumber2);
        porMesero = (EditText)findViewById(R.id.editTextNumber3);
        cantCocina = (EditText)findViewById(R.id.editTextNumber5);
        cantMesero = (EditText)findViewById(R.id.editTextNumber6);
        valorPropina = (EditText)findViewById(R.id.editTextNumber8);

        resPizzeria = (TextView)findViewById(R.id.textView17);
        resMesero = (TextView)findViewById(R.id.textView2);
        resCocina = (TextView)findViewById(R.id.textView10);
    }

    // ----------------------------------
    // Metodos
    // ----------------------------------

    public void calcularPorcentajes (View view){
        // Obtener datos
        String A1 = porPizzeria.getText().toString();
        int PorPizzeria = Integer.parseInt(A1);
        String A2 = porCocina.getText().toString();
        int PorCocina = Integer.parseInt(A2);
        String A3 = porMesero.getText().toString();
        int PorMesero = Integer.parseInt(A3);
        String A4 = cantCocina.getText().toString();
        int CantCocina = Integer.parseInt(A4);
        String A5 = cantMesero.getText().toString();
        int CantMesero = Integer.parseInt(A5);
        String A6 = valorPropina.getText().toString();
        int ValorPropina = Integer.parseInt(A6);

        double resPizzeria = ValorPropina * PorPizzeria / 100;
        double Rmesero = ValorPropina * PorMesero / 100;
        double Rcocina = ValorPropina * PorCocina / 100;
        double resMesero = Rmesero / CantMesero;
        double resCocina = Rcocina / CantCocina;

        String resultado1 = String.valueOf(resPizzeria);
        String resultado2 = String.valueOf(resMesero);
        String resultado3 = String.valueOf(resCocina);

        cantCocina.setText("");
        cantMesero.setText("");
        valorPropina.setText("");
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setMessage("¿Desea salir de la aplicación?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Salida");
        titulo.show();
    }

}