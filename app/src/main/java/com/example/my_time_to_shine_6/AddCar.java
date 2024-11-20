package com.example.my_time_to_shine_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.my_time_to_shine_6.util.Car;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddCar extends AppCompatActivity {

    EditText etName, etKm, etYear;
    TextView tvCity, tvQuestion;
    Spinner spinner;
    RadioGroup radioGroup;
    FloatingActionButton fabSend;
    Intent intent;
    public static final String CAR_KEY = "sendCar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_car);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponents();

        fabSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Car car = createCar();
                    intent.putExtra(CAR_KEY, car);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private boolean isValid() {
        if (etName.getText() == null || etName.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Invalid Car Model", Toast.LENGTH_SHORT).show();
            return false;
        } else if (etKm.getText() == null || etKm.getText().toString().trim().isEmpty() || Integer.parseInt(etKm.getText().toString().trim()) <= 0) {
            Toast.makeText(getApplicationContext(), "Invalid number of KM", Toast.LENGTH_SHORT);
            return false;
        } else if (etYear.getText() == null || etYear.getText().toString().trim().isEmpty() || Integer.parseInt(etYear.getText().toString().trim()) <= 0) {
            Toast.makeText(getApplicationContext(), "Invalid year", Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    private Car createCar() {
        String name = etName.getText().toString();
        int km = Integer.parseInt(etKm.getText().toString());
        int year = Integer.parseInt(etYear.getText().toString());
        return new Car(name, km, year);
    }

    private void initComponents() {
        etName = findViewById(R.id.etName);
        etKm = findViewById(R.id.etKm);
        etYear = findViewById(R.id.etYear);

        tvCity = findViewById(R.id.tvCity);
        tvQuestion = findViewById(R.id.tvQuestion);

        radioGroup = findViewById(R.id.radioGroup);

        fabSend = findViewById(R.id.fabSend);
        intent = getIntent();
    }
}