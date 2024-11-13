package com.example.hf06;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class CurrencyListFragment extends Fragment {

    private ListView listView;
    private CurrencyAdapter adapter;
    private List<Currency> currencyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_list, container, false);

        listView = view.findViewById(R.id.currencyListView);

        // Adatok inicializálása
        currencyList = new ArrayList<>();
        currencyList.add(new Currency("EUR", "Euro", 4.4100, 4.5500, R.drawable.eur));
        currencyList.add(new Currency("USD", "Dolar american", 3.9750, 4.1450, R.drawable.usd));
        currencyList.add(new Currency("GBP", "Lira sterlină", 6.1250, 6.3550, R.drawable.uk));
        currencyList.add(new Currency("AUD", "Dolar australian", 2.9600, 3.0600, R.drawable.aud));
        currencyList.add(new Currency("CAD", "Dolar canadian", 3.0950, 3.2650, R.drawable.cad));
        currencyList.add(new Currency("CHF", "Franc elvețian", 4.2300, 4.3300, R.drawable.chf));
        currencyList.add(new Currency("DKK", "Coroană daneză", 0.5850, 0.6150, R.drawable.dkk));
        currencyList.add(new Currency("HUF", "Forint maghiar", 0.0136, 0.0146, R.drawable.huf));

        adapter = new CurrencyAdapter(getContext(), currencyList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Currency selectedCurrency = currencyList.get(position);
            Toast.makeText(getContext(),
                    "Pénznem: " + selectedCurrency.getCode() + ", Vételi ár: " + selectedCurrency.getBuyRate() + " RON",
                    Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}