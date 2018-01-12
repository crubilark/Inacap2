package com.example.clrubilarc.inacap2.modelo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clrubilarc.inacap2.DetalleTeaActivity;
import com.example.clrubilarc.inacap2.R;

import java.util.ArrayList;

/**
 * Created by clrubilarc on 09-01-18.
 */

public class AdapterTea  extends RecyclerView.Adapter<AdapterTea.TeaViewHolder>{

    private ArrayList<Tea> list;
    private int resource; //layout/card
    private Activity activity;
    private Tea tea;

    public AdapterTea(ArrayList<Tea> list, int resource, Activity activity) {
        this.list = list;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public TeaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new TeaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeaViewHolder holder, int position) {
        tea = list.get(position);
        holder.cardTitle.setText(tea.getTitle());
        holder.cardImage.setImageResource(tea.getResourceImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeaViewHolder extends RecyclerView.ViewHolder{
        private ImageView cardImage;
        private TextView cardTitle;


        public TeaViewHolder(View itemView) {
            super(itemView);
            //importar R del package
            cardImage = itemView.findViewById(R.id.card_image);
            cardTitle = itemView.findViewById(R.id.card_title);

            cardImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(activity, DetalleTeaActivity.class);
                    i.putExtra("TITLE",cardTitle.getText().toString());
                    i.putExtra("IMG",Tea.getImageDrawable(cardTitle.getText().toString()));
                    activity.startActivity(i);
                }
            });
        }
    }
}
