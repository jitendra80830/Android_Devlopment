package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    public  void playGameClicked(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void playerTapped(View view){
        ImageView imageView = (ImageView) view;
        int tag = Integer.parseInt(imageView.getTag().toString());

        Toast.makeText(getApplicationContext(),"Tapped" + tag,Toast.LENGTH_LONG).show();
    }

}