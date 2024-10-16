package com.example.tablelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Product> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addProduct = findViewById(R.id.btnAddProduct);
        Button cancel = findViewById(R.id.btnCancel);
        Button showProducts = findViewById(R.id.btnShowProducts);

        EditText inputCode = findViewById(R.id.edtProductCode);
        EditText inputName = findViewById(R.id.edtProductName);
        EditText inputPrice = findViewById(R.id.edtProductPrice);
        TextView txtProducts = findViewById(R.id.txtProducts);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = inputCode.getText().toString();
                String name = inputName.getText().toString();
                String price = inputPrice.getText().toString();
                products.add(new Product(code,name,price));

                Toast.makeText(MainActivity.this,"Product succesfuly added!",Toast.LENGTH_SHORT).show();

                inputCode.setText("");
                inputName.setText("");
                inputPrice.setText("");
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputCode.setText("");
                inputName.setText("");
                inputPrice.setText("");
            }
        });

        showProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Product product:products){
                    txtProducts.append(product + "\n");
                }
            }
        });

    }
}