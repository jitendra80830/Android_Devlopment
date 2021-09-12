package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;

    NotificationCounter notificationCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        notificationCounter = new NotificationCounter(findViewById(R.id.bell));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationCounter.increaseNumber();
            }
        });
    }
}