package com.example.hf07;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.VH>{
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_row, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.image.setImageResource(imageArray[position]);
        holder.name.setText(nameArray[position]);
        holder.info.setText(infoArray[position]);
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return nameArray.length;
    }

    private Activity context;
    private String[] nameArray;
    private String[] infoArray;
    private Integer[] imageArray;

    public CardViewAdapter(Activity context, String[] nameArray, String[] infoArray, Integer[] imageArray) {
        this.context = context;
        this.nameArray = nameArray;
        this.infoArray = infoArray;
        this.imageArray = imageArray;
    }

    public class VH extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView info;
        int position;

        public VH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.txtName);
            info = itemView.findViewById(R.id.txtInfo);
            position = 0;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),nameArray[position],Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
