package com.example.my_time_to_shine_6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutActivity extends AppCompatActivity {
    Intent intent;

    TextView tvName, tvAge, tvOccupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponents();

        if (intent.hasExtra(MainActivity.NAME_KEY)) {
            String name = intent.getStringExtra(MainActivity.NAME_KEY);
            tvName.setText(name);
        }
        if (intent.hasExtra(MainActivity.AGE_KEY)) {
            String age = String.valueOf(intent.getIntExtra(MainActivity.AGE_KEY, 0));
            tvAge.setText(age);
        }
        if (intent.hasExtra(MainActivity.OCCUPATION_KEY)) {
            String occ = intent.getStringExtra(MainActivity.OCCUPATION_KEY);
            tvOccupation.setText(occ);
        }
    }

    private void initComponents() {
        intent = getIntent();
        tvName = findViewById(R.id.tvname);
        tvAge = findViewById(R.id.tvAge);
        tvOccupation = findViewById(R.id.tvOccupation);
    }
}