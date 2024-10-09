package com.example.activitylifecyclemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView cimke;
    EditText text;
    CheckBox checkBox;

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

        Log.d("Statusz:", "MainActivity - onCreate");

        Button button = findViewById(R.id.btnStart);
        cimke = findViewById(R.id.txtCimke);
        text = findViewById(R.id.edtText);
        checkBox = findViewById(R.id.checkBox);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        cimke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cimke.append("\n" + cimke.getText().toString());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Statusz:", "MainActivity - onSaveInstanceState");
        outState.putString("cimke",cimke.getText().toString());
        outState.putString("txt",text.getText().toString());
        outState.putBoolean("check",checkBox.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Statusz:", "MainActivity - onRestoreInstanceState");
        cimke.setText(savedInstanceState.getString("cimke"));
        text.setText(savedInstanceState.getString("txt"));
        checkBox.setChecked(savedInstanceState.getBoolean("check"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz:", "MainActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz:", "MainActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz:", "MainActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz:", "MainActivity - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz:", "MainActivity - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz:", "MainActivity - onDestroy");
    }

}