package com.example.my_time_to_shine_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.my_time_to_shine_6.util.Car;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String NAME_KEY = "sendName";
    public static final String AGE_KEY = "sendAge";
    public static final String OCCUPATION_KEY = "sendOccupation";
    FloatingActionButton fabAdd;
    FloatingActionButton fabSettings;

    ListView listView;
    List<Car> carList = new ArrayList<>();

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if (o.getResultCode() == RESULT_OK) {
                        Intent intent = new Intent();
                        intent.getData();

                        if (intent != null) {
                            Car car = (Car) o.getData().getSerializableExtra(AddCar.CAR_KEY);
                            carList.add(car);
                            ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });

    ActivityResultLauncher<Intent> setiingsActivityLauncer = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {

                }
            });


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

        initComponents();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCar.class);
                activityLauncher.launch(intent);
            }
        });


        fabSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                setiingsActivityLauncer.launch(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast.makeText(getApplicationContext(), R.string.item_1, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.item2) {
            Toast.makeText(getApplicationContext(), R.string.item_2, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.about) {
            Toast.makeText(getApplicationContext(), R.string.about, Toast.LENGTH_LONG).show();
            String name = "Matei";
            int age = 24;
            String occupation = "developer";

            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            intent.putExtra(NAME_KEY, name);
            intent.putExtra(AGE_KEY, age);
            intent.putExtra(OCCUPATION_KEY, occupation);

            startActivity(intent);
        }
        return true;
    }

    private void initComponents() {
        fabAdd = findViewById(R.id.floatingActionButton);
        fabSettings = findViewById(R.id.fabSettings);
        listView = findViewById(R.id.listView);
        ArrayAdapter<Car> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, carList);
        listView.setAdapter(arrayAdapter);
    }

}