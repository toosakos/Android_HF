package com.example.hf06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CurrencyAdapter extends ArrayAdapter<Currency> {

    private Context context;
    private List<Currency> currencyList;

    public CurrencyAdapter(Context context, List<Currency> currencies) {
        super(context, 0, currencies);
        this.context = context;
        this.currencyList = currencies;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.currency_list_item, parent, false);
        }

        Currency currency = currencyList.get(position);

        ImageView flagImageView = convertView.findViewById(R.id.flagImageView);
        TextView currencyCodeTextView = convertView.findViewById(R.id.currencyCodeTextView);
        TextView currencyNameTextView = convertView.findViewById(R.id.currencyNameTextView);
        TextView buyRateTextView = convertView.findViewById(R.id.buyRateTextView);
        TextView sellRateTextView = convertView.findViewById(R.id.sellRateTextView);

        // Set values
        flagImageView.setImageResource(currency.getFlagResId()); // Zászló ikon beállítása
        currencyCodeTextView.setText(currency.getCode());
        currencyNameTextView.setText(currency.getName());
        buyRateTextView.setText("Cumpără: " + currency.getBuyRate() + " RON");
        sellRateTextView.setText("Vinde: " + currency.getSellRate() + " RON");

        return convertView;
    }
}
