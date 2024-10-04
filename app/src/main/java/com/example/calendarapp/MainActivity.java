package com.example.calendarapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    CalendarView calendarView;

    @SuppressLint("StaticFieldLeak")
    public static ListView listView;
    @SuppressLint("StaticFieldLeak")
    public static ArrayList<String> events;
    public static String currentSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);
        addButton = findViewById(R.id.addButton);
        listView = findViewById(R.id.listView);
        events = new ArrayList<>();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addButton.setOnClickListener(view -> startActivity(new Intent(this, EventCreator.class)));
        calendarView.setOnDateChangeListener((calendarView, i, i1, i2) -> currentSelectedDate = String.format("%s/%s/%s", i, i1, i2));
    }
}