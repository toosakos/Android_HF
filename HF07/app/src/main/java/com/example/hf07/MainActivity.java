package com.example.hf07;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Octopus","Pig","Sheep","Rabbit",
            "Cat","Dog","Giraffe","Horse","Lion" };

    String[] infoArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Moody friend",
            "Man's best friend",
            "Long neck",
            "Fast",
            "King of the animals"
    };

    Integer[] imageArray = {
            R.drawable.octopus3,
            R.drawable.disznyo,
            R.drawable.sheep,
            R.drawable.rabbit,
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.giraffe,
            R.drawable.horse,
            R.drawable.lion
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

        RecyclerView rvContacts = findViewById(R.id.myList);
        rvContacts.setHasFixedSize(true);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter adapter = new CardViewAdapter(this,nameArray,infoArray,imageArray);
        rvContacts.setAdapter(adapter);

    }
}