package com.example.hazifeladat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListAdapter extends ArrayAdapter {
    private Activity context;
    private String[] nameArray;
    private String[] infoArray;
    private Integer[] imageArray;
    private Double[] buyArray;
    private Double[] sellArray;

    public CustomListAdapter(@NonNull Activity context, String[] nameArray, String[] infoArray, Integer[] imageArray, Double[] buyArray, Double[] sellArray) {
        super(context, R.layout.listview_row, nameArray);
        this.context = context;
        this.nameArray = nameArray;
        this.infoArray = infoArray;
        this.imageArray = imageArray;
        this.buyArray = buyArray;
        this.sellArray = sellArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        // refernciak kinyerese
        TextView name = rowView.findViewById(R.id.txtName);
        TextView info = rowView.findViewById(R.id.txtInfo);
        TextView buy = rowView.findViewById(R.id.txtBuy);
        TextView sell = rowView.findViewById(R.id.txtSell);
        ImageView image = rowView.findViewById(R.id.imageView);

        //beallitjuk az uj ertekeket
        name.setText(nameArray[position]);
        info.setText(infoArray[position]);
        buy.setText(buyArray[position].toString());
        sell.setText(sellArray[position].toString());
        image.setImageResource(imageArray[position]);

        return rowView;
    }
}
