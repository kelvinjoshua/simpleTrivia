package com.example.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.questions.databinding.ActivityMainBinding;
import com.example.questions.model.Question;
import com.google.android.material.snackbar.Snackbar;

import static android.content.ContentValues.TAG;
import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {


    public ActivityMainBinding binding;
    private final Question [] question = new Question[]{
            new Question(R.string.church,true),new Question(R.string.countries,false),new Question(R.string.independence,true),new Question(R.string.tourism,true)
    };
    public int questLen = question.length;
    public int i = 0;//current index
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.True.setOnClickListener(view -> checkAnswer(true));
        binding.False.setOnClickListener(view -> checkAnswer(false));
        binding.foward.setOnClickListener(v -> {
            i = (i = i + 1) % questLen;//prevent out of bounds i += 1
            Log.d(TAG, "the value is : "+ i);
            update();

        });
        binding.back.setOnClickListener(v -> {
            //only if the index is 1 to 3 allow previous question
            if(i > 0){
                i = (i -= 1) % questLen;
                update();
            }
        });
    }

    private void checkAnswer(boolean answer) {
        boolean compare  = question[i].isAnswerCorrect();
        if(answer == compare){
            Snackbar.make(binding.True, R.string.correct_answer, Snackbar.LENGTH_LONG).show();
        }
        else {
            Snackbar.make(binding.False, R.string.wrong_answer, Snackbar.LENGTH_LONG).show();
        }
    }

    private void update() {
        binding.Question.setText(question[i].getQuestionId());
    }
}