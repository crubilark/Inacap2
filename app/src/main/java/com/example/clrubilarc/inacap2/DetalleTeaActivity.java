package com.example.clrubilarc.inacap2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class DetalleTeaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //activa flecha atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title =getIntent().getStringExtra("TITLE");
        int resourceImg = getIntent().getIntExtra("IMG",R.drawable.black_tea);

        getSupportActionBar().setTitle(title);
        //cast castear
        ImageView imageView = (ImageView) findViewById(R.id.detalle_image);
        imageView.setImageResource(resourceImg);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                Intent i = new Intent(getApplicationContext(), CommentActivity.class);
                startActivity(i);
            }
        });
    }
}
