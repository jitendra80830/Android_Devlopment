package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    TextView textView1;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Want to go to next Activity",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);

            }
        });

    }

    public void performOperation(View view) {
        editText1 = findViewById(R.id.editTextNumber);
        editText2 = findViewById(R.id.editTextNumber2);
        textView1 = findViewById(R.id.textView);

        int result = 0,eText1,eText2;

        if(editText1.getText().toString().isEmpty() ||
                editText2.getText().toString().isEmpty()){
            Toast.makeText(this,"Incorrect Inputs",Toast.LENGTH_LONG).show();
        }else {

            eText1 = Integer.parseInt(editText1.getText().toString());
            eText2 = Integer.parseInt(editText2.getText().toString());

            ImageButton imageButton = (ImageButton) view;

            if(imageButton.getTag().equals("add")){
                result = eText1 + eText2;
            }else if(imageButton.getTag().equals("sub")){
                result = eText1 - eText2;
            }

            textView1.setText("Result: " + result);
        }

    }
}