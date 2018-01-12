package com.example.clrubilarc.inacap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //visualizar Toolbar del xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.mi_toolbar);
        //Definir Toolbar
        setSupportActionBar(toolbar);
        //definir titulos
        getSupportActionBar().setTitle("Curso Android");
        getSupportActionBar().setSubtitle("Martes");
    }

    public void launchinvitacion(View view) {
        Intent intento = new Intent (this, InvitacionActivity.class);
        startActivity(intento);
    }

    public void launchBasket(View view) {
    }

    public void launchCoffe(View view) {
        Intent intento3 = new Intent (this, CoffeActivity.class);
        startActivity(intento3);
    }

    public void launchTea(View view) {
        Intent intento4 = new Intent (this, TeaActivity.class);
        startActivity(intento4);
    }
}
