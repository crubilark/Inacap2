package com.example.clrubilarc.inacap2;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clrubilarc.inacap2.modelo.Comment;

import java.util.ArrayList;

/**
 * Created by clrubilarc on 10-01-18.
 */

public class AdapterComment  extends RecyclerView.Adapter<AdapterComment.CommentViewHolder>{

    private ArrayList<Comment> lista;
    private int resource; //asociado al nombre del layout (RelativeLayout)
    private Activity activity;

    public AdapterComment(ArrayList<Comment> lista, int resource, Activity activity) {
        this.lista = lista;
        this.resource = resource;
        this.activity = activity;

    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment comment = lista.get(position);
        holder.itemName.setText(comment.getName());
        holder.itemComment.setText(comment.getComment());
        //capturar la primera letra
        holder.itemCircle.setText(comment.getName().substring(0,1).toUpperCase());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private TextView itemCircle,itemName,itemComment;

        public CommentViewHolder(View itemView) {
            super(itemView);
            itemCircle = itemView.findViewById(R.id.itemCircle);
            itemName = itemView.findViewById(R.id.itemName);
            itemComment = itemView.findViewById(R.id.itemComment);
        }
    }
}
