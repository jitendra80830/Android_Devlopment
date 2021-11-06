package com.example.quizme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.quizme.databinding.ActivityResultBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding binding;
    int POINTS =10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int correctAnswer = getIntent().getIntExtra("correct" ,0);
        int totalQuestion = getIntent().getIntExtra("total" ,0);

        long points = correctAnswer * POINTS;

        binding.score.setText(String.format("%d/%d" ,correctAnswer , totalQuestion));
        binding.earncoins.setText(String.valueOf(points));

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection("users")
                .document(FirebaseAuth.getInstance().getUid())
                .update("coins" , FieldValue.increment(points));
    }
}