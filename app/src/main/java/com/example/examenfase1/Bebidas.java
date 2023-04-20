package com.example.examenfase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Bebidas extends AppCompatActivity {
    public static double totalBebidas = 0.0;
    CheckBox inkaCola, pepsi, energina,cocaCola, fanta;
    SharedPreferences sharedPreferences;
    Button aceptarBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        // Obtener una instancia de SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        inkaCola = (CheckBox) findViewById(R.id.inkaColaCheckBox);
        fanta = (CheckBox) findViewById(R.id.fantaCheckBox);
        pepsi= (CheckBox) findViewById(R.id.pepsiCheckBox);
        energina = (CheckBox) findViewById(R.id.energinaCheckBox);
        cocaCola = (CheckBox) findViewById(R.id.cocacolaCheckBox);
        aceptarBebidas = findViewById(R.id.aceptarBebidas);

        // Restaurar el estado anterior de las casillas marcadas
        inkaCola.setChecked(sharedPreferences.getBoolean("inkaColaChecked", false));
        fanta.setChecked(sharedPreferences.getBoolean("fantaChecked", false));
        pepsi.setChecked(sharedPreferences.getBoolean("pepsiChecked", false));
        energina.setChecked(sharedPreferences.getBoolean("energinaChecked", false));
        cocaCola.setChecked(sharedPreferences.getBoolean("cocaColaChecked", false));
    }
    @Override
    protected void onPause() {
        super.onPause();

        // Guardar el estado actual de las casillas marcadas
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("inkaColaChecked", inkaCola.isChecked());
        editor.putBoolean("fantaChecked", fanta.isChecked());
        editor.putBoolean("pepsiChecked", pepsi.isChecked());
        editor.putBoolean("energinaChecked", energina.isChecked());
        editor.putBoolean("cocaColaChecked", cocaCola.isChecked());
        editor.apply();
    }
    public void onClick(View v){
        if (v.getId() == R.id.aceptarBebidas){
            calcularTotalBebidas();
        }
    }
    public void calcularTotalBebidas(){
        String cad = "Añadido a la compra: \n";
        double precioFanta = 2.00;
        double precioPepsi = 2.00;
        double precioEnergina = 1.00;
        double precioCocaCola = 3.00;
        double precioInkaCola = 2.50;


        if (inkaCola.isChecked()){
            totalBebidas += precioInkaCola + 2.50;
            cad += "Inka Cola\n";
        }
        if (fanta.isChecked()){
            totalBebidas += precioFanta + 2.00;
            cad += "Fanta\n";
        }
        if (pepsi.isChecked()){
            totalBebidas += precioPepsi + 2.00;
            cad += "Pepsi\n";
        }
        if (energina.isChecked()){
            totalBebidas += precioEnergina + 1.00;
            cad += "Energina\n";
        }
        if (cocaCola.isChecked()){
            totalBebidas += precioCocaCola + 3.00;
            cad += "Coca Cola\n";
        }
        CostoTotal.costoBebidas = totalBebidas;
        Toast.makeText(getApplicationContext(), cad, Toast.LENGTH_SHORT).show();
    }


}