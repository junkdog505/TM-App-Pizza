package com.example.examenfase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.examenfase1.Bebidas;
import com.example.examenfase1.Pizzas;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class CostoTotal extends AppCompatActivity{
    public static double costoBebidas;
    public static double costoPizzas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costo_total);
        EditText totalB = findViewById(R.id.cajaBebidas);
        totalB.setText(String.valueOf(totalB));
        EditText totalP = findViewById(R.id.cajaPizzas);
        totalP.setText(String.valueOf(totalP));
    }
    public void onClick(View v) {
        if (v.getId() == R.id.aceptarTotal){
            mostraCostoTotal();
        }
    }
    public void mostraCostoTotal(){
        EditText cajaBebidas = findViewById(R.id.cajaBebidas);
        cajaBebidas.setText(String.valueOf(String.format("%.2f", costoBebidas)));

        EditText cajaPizzas = findViewById(R.id.cajaPizzas);
        cajaPizzas.setText(String.valueOf(String.format("%.2f", costoPizzas)));
        // Calcula el costo total sumando costoBebidas y costoPizzas
        double costoTotal = costoBebidas + costoPizzas;

        // Obtén una referencia al EditText en el que se mostrará el costo total
        EditText editTextCostoTotal = findViewById(R.id.cajaTotal);

        // Muestra el costo total en el EditText
        editTextCostoTotal.setText(String.valueOf(String.format("%.2f", costoTotal)));
    }
}