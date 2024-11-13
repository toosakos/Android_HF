package com.example.hf5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<String> items;
    private Context context;
    private int selectedColor = Color.BLACK;

    public ListAdapter(List<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
        holder.textView.setTextColor(selectedColor);

        // Context menu regisztrálása
        holder.itemView.setOnLongClickListener(v -> {
            holder.itemView.showContextMenu();
            return true;
        });
    }

    public void setSelectedColor(int color) {
        this.selectedColor = color;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            itemView.setOnCreateContextMenuListener((menu, v, menuInfo) -> {
                menu.add("Piros").setOnMenuItemClickListener(item -> {
                    setSelectedColor(Color.RED);
                    return true;
                });
                menu.add("Zöld").setOnMenuItemClickListener(item -> {
                    setSelectedColor(Color.GREEN);
                    return true;
                });
                menu.add("Sárga").setOnMenuItemClickListener(item -> {
                    setSelectedColor(Color.YELLOW);
                    return true;
                });
            });
        }
    }
}
