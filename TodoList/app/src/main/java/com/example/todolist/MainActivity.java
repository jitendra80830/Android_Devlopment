package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TaskAdapter taskAdapter;
    ImageView imageViewNewTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        populateTask();

        imageViewNewTask = findViewById(R.id.imageViewNewTask);

        imageViewNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void populateTask() {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task("Task1","Description1"));
        taskList.add(new Task("Task2","Description2"));
        taskList.add(new Task("Task3","Description3"));
        taskList.add(new Task("Task4","Description4"));
        taskList.add(new Task("Task5","Description5"));
        taskList.add(new Task("Task5","Description6"));

        taskAdapter = new TaskAdapter(taskList,this);

        recyclerView.setAdapter(taskAdapter);
    }
}