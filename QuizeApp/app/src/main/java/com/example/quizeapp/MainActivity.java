package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView optionA , optionB , optionC , optionD;

    private TextView questionNumber , question , score;
    private TextView checkout1 , getCheckout2;

    int currentIndex;
    int mScore =0;
    int qn =1;
    ProgressBar progressBar;

    int currentQuestion , currentOptionA , currentOptionB , currentOptionC , currentOptionD;

    private AnswerClass[] questionBank = new AnswerClass[]
            {
                    new AnswerClass(R.string.question_1 , R.string.question1_A  , R.string.question1_B , R.string.question1_C , R.string.question1_D , R.string.answer_1),
                    new AnswerClass(R.string.question_2 , R.string.question_2A , R.string.question_2B, R.string.question_2C , R.string.question_2D,R.string.answer_2),
                    new AnswerClass(R.string.question_3 , R.string.question_3A , R.string.question_3B , R.string.question_3C ,R.string.question_3D , R.string.answer_3),
                    new AnswerClass(R.string.question_4 , R.string.question_4A , R.string.question_4B , R.string.question_4C ,R.string.question_4D , R.string.answer_4),
                    new AnswerClass(R.string.question_5 , R.string.question_5A , R.string.question_5B , R.string.question_5C ,R.string.question_5D , R.string.answer_5),
                    new AnswerClass(R.string.question_6 , R.string.question_6A , R.string.question_6B , R.string.question_6C ,R.string.question_6D , R.string.answer_6),
                    new AnswerClass(R.string.question_7 , R.string.question_7A , R.string.question_7B , R.string.question_7C ,R.string.question_7D , R.string.answer_7),
                    new AnswerClass(R.string.question_8, R.string.question_8A , R.string.question_8B , R.string.question_8C ,R.string.question_8D , R.string.answer_8)
    };

    final  int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        questionNumber = findViewById(R.id.QuestionNumber);
        score = findViewById(R.id.score);

        checkout1 = findViewById(R.id.selectedOption);
        getCheckout2 = findViewById(R.id.CorrectAnswer);

        progressBar = findViewById(R.id.progress_bar);

        currentQuestion = questionBank[currentIndex].getQuestionId();
        question.setText(currentQuestion);

        currentOptionA = questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);

        currentOptionB = questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);

        currentOptionC = questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);;

        currentOptionD = questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionA);
                updateQuestion();

            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionB);
                updateQuestion();


            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionC);
                updateQuestion();


            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentOptionD);
                updateQuestion();


            }
        });
    }

    private void checkAnswer(int userSelection) {

    }

    private void updateQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.length;

        currentQuestion = questionBank[currentIndex].getQuestionId();
        question.setText(currentQuestion);

        currentOptionA = questionBank[currentIndex].getOptionA();
        optionA.setText(currentOptionA);

        currentOptionB = questionBank[currentIndex].getOptionB();
        optionB.setText(currentOptionB);

        currentOptionC = questionBank[currentIndex].getOptionC();
        optionC.setText(currentOptionC);;

        currentOptionD = questionBank[currentIndex].getOptionD();
        optionD.setText(currentOptionD);

        qn = qn + 1;

        if(qn < questionBank.length){
            questionNumber.setText(qn+"/" +questionBank.length +" questions");
        }
        score.setText("Score" +mScore +"/" +questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);

    }
}