package com.example.clrubilarc.inacap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.clrubilarc.inacap2.modelo.AdapterTea;
import com.example.clrubilarc.inacap2.modelo.Tea;

public class TeaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclear_tea);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(new AdapterTea(Tea.teaList(),R.layout.card_tea,this));


    }
}
