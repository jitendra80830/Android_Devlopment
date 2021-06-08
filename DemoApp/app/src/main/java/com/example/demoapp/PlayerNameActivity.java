package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerNameActivity<sharedPreferences> extends AppCompatActivity {

    EditText editTextPlayer1,editTextPlayer2;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        editTextPlayer1 = findViewById(R.id.editTextTextPersonName);
        editTextPlayer2 = findViewById(R.id.editTextTextPersonName2);

        //add the name which is stored in preference
        editTextPlayer1.setText(sharedPreferences.getString("player1",""));
        editTextPlayer2.setText(sharedPreferences.getString("player2",""));

    }
    public void startButtonClicked(View view){


        if(editTextPlayer1.getText().toString().isEmpty() || editTextPlayer2.getText().toString().isEmpty()){

            Toast.makeText(this,"Please Enter Player's Name",Toast.LENGTH_LONG).show();
        }else {

            //store the data of player in Shared preference
            String player1 = editTextPlayer1.getText().toString();
            String player2 = editTextPlayer2.getText().toString();

            sharedPreferences.edit().putString("player1",player1).putString("player2",player2).apply();

            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }

    }
}