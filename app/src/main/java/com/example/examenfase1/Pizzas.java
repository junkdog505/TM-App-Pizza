package com.example.examenfase1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pizzas extends AppCompatActivity {

    public static double totalPizzas = 0.0;
    CheckBox pizzaPeperonni;
    CheckBox pizzaHawaiana;
    CheckBox pizzaMargherita;
    SharedPreferences sharedPreferences;
    Button aceptarPizzas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);

        // Obtener una instancia de SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        pizzaPeperonni = findViewById(R.id.pizzaPeperonniCheckBox);
        pizzaHawaiana = findViewById(R.id.pizzaHawaianaCheckBox);
        pizzaMargherita = findViewById(R.id.pizzaMargheritaCheckBox);
        aceptarPizzas = findViewById(R.id.aceptarPizzas);

        // Restaurar el estado anterior de las casillas marcadas
        pizzaPeperonni.setChecked(sharedPreferences.getBoolean("peperonniChecked", false));
        pizzaHawaiana.setChecked(sharedPreferences.getBoolean("hawaianaChecked", false));
        pizzaMargherita.setChecked(sharedPreferences.getBoolean("margheritaChecked", false));
    }
    @Override
    protected void onPause() {
        super.onPause();

        // Guardar el estado actual de las casillas marcadas
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("peperonniChecked", pizzaPeperonni.isChecked());
        editor.putBoolean("hawaianaChecked", pizzaHawaiana.isChecked());
        editor.putBoolean("margheritaChecked", pizzaMargherita.isChecked());
        editor.apply();
    }
    public void onClick(View v) {
        if (v.getId() == R.id.aceptarPizzas){
            calcularTotalPizzas();
        }
    }
    public void calcularTotalPizzas() {
        String cad = "Añadido a la compra: \n";
        double precioPizzaPeperonni = 18.50;
        double precioPizzaHawaiana = 22.00;
        double precioPizzaMargherita = 25.99;


        if (pizzaPeperonni.isChecked()) {
            totalPizzas += precioPizzaPeperonni;
            cad += "Pizza Peperonni \n";
        }
        if (pizzaHawaiana.isChecked()) {
            totalPizzas += precioPizzaHawaiana;
            cad += "Pizza Hawaiana \n";
        }
        if (pizzaMargherita.isChecked()) {
            totalPizzas += precioPizzaMargherita;
            cad += "Pizza Margherita \n";
        }
        CostoTotal.costoPizzas = totalPizzas;
        Toast.makeText(getApplicationContext(), cad, Toast.LENGTH_SHORT).show();
    }
}