package com.example.clrubilarc.inacap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CoffeActivity extends AppCompatActivity {

    private EditText txtNombre;
    private TextView txtCantidad;
    private TextView txtResultado;
    private CheckBox opcream, opcho;
    private int cantidad, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mi_toolbar);
        //Definir Toolbar
        setSupportActionBar(toolbar);
        //definir titulos
        getSupportActionBar().setTitle("Coffe");
        getSupportActionBar().setSubtitle("Martes");
        //obtener datos del formulario
        txtNombre = (EditText) findViewById(R.id.txtnombre);
        txtCantidad = (TextView) findViewById(R.id.txtcantidad);
        txtResultado = (TextView) findViewById(R.id.txtresultado);
        opcream = (CheckBox) findViewById(R.id.opCream);
        opcho = (CheckBox)findViewById(R.id.opCho);
        cantidad = 1;

    }

    public void order(View view) {
        if(!txtNombre.getText().toString().isEmpty()){
        total = 10;
        if(opcream.isChecked()){
            total +=4;
        }

        if(opcho.isChecked()){
            total +=5;
        }
        total *= cantidad;
        String resultado="";
        resultado = resultado.concat("Price\n");
        resultado = resultado.concat("Quiantify\n"+cantidad+"\n");
        resultado = resultado.concat("Total $"+total+"\n");
        resultado = resultado.concat("Cream $"+opcream.isChecked()+"\n");
        resultado = resultado.concat("Cream $"+opcho.isChecked()+"\n");
        resultado = resultado.concat("Gracias");
            txtResultado.setText(resultado);
    }else{
        Toast.makeText(this,"entra tu nombre,",Toast.LENGTH_SHORT).show();
    }
    }

    public void mas(View view) {
        if(cantidad < 10 ){
            cantidad++;
            txtCantidad.setText(String.valueOf(cantidad));
        }
    }

    public void menos(View view) {
        if(cantidad > 1 ){
            cantidad--;
            txtCantidad.setText(String.valueOf(cantidad));
        }
    }
}
