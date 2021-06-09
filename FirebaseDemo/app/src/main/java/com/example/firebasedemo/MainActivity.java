package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button submitBtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextName);
        submitBtm = findViewById(R.id.button);


        submitBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(MainActivity.this,"value: " + editText.getText().toString(),Toast.LENGTH_LONG).show();

                Log.d("MyResult","Button Clicked");
                String value = editText.getText().toString();

                FirebaseDatabase.getInstance().getReference("sameData").setValue(value).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){

                        Toast.makeText(MainActivity.this,"Added to Firebase",Toast.LENGTH_LONG).show();

                    }else {

                        Toast.makeText(MainActivity.this,"Fail to add",Toast.LENGTH_LONG).show();
                    }

                });
            }
        });

    }
}