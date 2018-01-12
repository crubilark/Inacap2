package com.example.clrubilarc.inacap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class InvitacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitacion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mi_toolbar);
        //Definir Toolbar
        setSupportActionBar(toolbar);
        //definir titulos
        getSupportActionBar().setTitle("Invitacion");
        getSupportActionBar().setSubtitle("Martes");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}
