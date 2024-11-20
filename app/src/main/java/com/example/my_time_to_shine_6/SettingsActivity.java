package com.example.my_time_to_shine_6;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.my_time_to_shine_6.util.Settings;

public class SettingsActivity extends AppCompatActivity {

    EditText etSettings;
    Spinner spinnerSettings;
    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponents();

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings settings = createSetting();
            }
        });
    }

    private Settings createSetting() {
        String writeSomething = etSettings.getText().toString();
        String city = spinnerSettings.getSelectedItem().toString();
        return new Settings(writeSomething, city);
    }

    private void initSpinner() {
        spinnerSettings = findViewById(R.id.spinnerSettings);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.settingsSpinner, android.R.layout.simple_spinner_item);
        spinnerSettings.setAdapter(arrayAdapter);
    }

    private void initComponents() {
        etSettings = findViewById(R.id.etSettings);
        initSpinner();
        btnSettings= findViewById(R.id.btnSettings);
    }
}