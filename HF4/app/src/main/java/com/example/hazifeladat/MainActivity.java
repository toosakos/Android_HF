package com.example.hazifeladat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {






    String[] nameArray = {"Euro","Amerikai Dollár","Angol Font","Svájci Frank",
            "Dán Korona","Kanadai Dollár","Ausztrál Dollár","Magyar Forint"};

    String[] infoArray = {
            "EUR",
            "USD",
            "GBP",
            "CHF",
            "DKK",
            "CAD",
            "AUD",
            "HUF"
    };

    Double[] buyArray = {
            4.95,
            4.56,
            5.90,
            5.25,
            0.57,
            3.23,
            2.80,
            0.0124
    };

    Double[] sellArray = {
            4.995,
            4.66,
            5.99,
            5.34,
            0.63,
            3.33,
            3.06,
            0.01265
    };


    Integer[] imageArray = {
            R.drawable.eur,
            R.drawable.usd,
            R.drawable.uk,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.cad,
            R.drawable.aud,
            R.drawable.huf
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView list = findViewById(R.id.customListView);
        CustomListAdapter adapter = new CustomListAdapter(this,nameArray,infoArray,imageArray,buyArray,sellArray);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, infoArray[position] + buyArray[position], Toast.LENGTH_SHORT).show();
            }
        });


    }
}
