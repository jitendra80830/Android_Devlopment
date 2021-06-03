package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerNameActivity extends AppCompatActivity {

    EditText editTextPlayer1,editTextPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        editTextPlayer1 = findViewById(R.id.editTextTextPersonName);
        editTextPlayer2 = findViewById(R.id.editTextTextPersonName2);

    }
    public void startButtonClicked(View view){


        if(editTextPlayer1.getText().toString().isEmpty() || editTextPlayer2.getText().toString().isEmpty()){

            Toast.makeText(this,"Please Enter Player's Name",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }

    }
}