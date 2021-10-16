package com.example.quizme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizme.databinding.ActivityQuizBinding;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<Question> questions;

    int index =0;
    Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questions = new ArrayList<>();

        questions.add(new Question("What is earth","Planet","Sun","Human","Car","Planet"));
        questions.add(new Question("What is Java","Compiler","Database","Human","Programming","Programming"));

        setNextQuestions();
    }
    void showAnswer(){
        if(question.getAnswer().equals(binding.opiton1.getText().toString())){
            binding.opiton1.setBackground(getResources().getDrawable(R.drawable.option_right));
        }else if(question.getAnswer().equals(binding.option2.getText().toString())){
            binding.option2.setBackground(getResources().getDrawable(R.drawable.option_right));
        }else if(question.getAnswer().equals(binding.option3.getText().toString())){
            binding.option3.setBackground(getResources().getDrawable(R.drawable.option_right));
        }else if(question.getAnswer().equals(binding.option4.getText().toString())){
            binding.option4.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
    }
    void setNextQuestions(){
        if(index < questions.size()){
            binding.questioncounter.setText(String.format("%d/%d",(index+1 ),questions.size()));
            question = questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.opiton1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());

        }
    }
    public void checkAnswer(TextView textView){
        String answerSelected = textView.getText().toString();

        if(answerSelected.equals(question.getAnswer())){
            textView.setBackground(getResources().getDrawable(R.drawable.option_right));
        }else {
            showAnswer();
            textView.setBackground(getResources().getDrawable(R.drawable.option_wrongt));

        }

    }
    void reset(){
        binding.opiton1.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option2.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option3.setBackground(getResources().getDrawable(R.drawable.option_unselected));
        binding.option4.setBackground(getResources().getDrawable(R.drawable.option_unselected));
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.opiton_1:
            case R.id.option_2:
            case R.id.option_3:
            case R.id.option_4:
                TextView selected = (TextView) view;
                checkAnswer(selected);

                break;

            case R.id.nextButton:
                reset();
                if(index < questions.size()) {
                    index++;
                    setNextQuestions();
                }else {
                    Toast.makeText(this ,"Quiz Finished",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}