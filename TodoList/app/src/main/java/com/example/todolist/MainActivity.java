package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TaskAdapter taskAdapter;
    ImageView imageViewNewTask;
    ArrayList<Task> taskList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        taskList = new ArrayList<Task>();

       //taskList.add(new Task("Task1","Description1"));
        //taskList.add(new Task("Task2","Description2"));
        //taskList.add(new Task("Task3","Description3"));
       // taskList.add(new Task("Task4","Description4"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        populateTask();

        imageViewNewTask = findViewById(R.id.imageViewNewTask);

        imageViewNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.new_task,null,false);


                new AlertDialog.Builder(MainActivity.this).setTitle("Add a new Task ").setView(view)
                        .setPositiveButton("+", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText editTextTitle,editTextDescription;
                                editTextTitle = view.findViewById(R.id.editTextTextTitle);
                                editTextDescription = view.findViewById(R.id.editTextTextDescription);

                                new TaskHandler(MainActivity.this).createTask(
                                        new Task(editTextTitle.getText().toString()
                                                ,editTextDescription.getText().toString()));
                                populateTask();
                                
                            }
                        }).show();

            }
        });
    }

    private void populateTask() {
        taskList = new TaskHandler(this).getAllTask();

        taskAdapter = new TaskAdapter(taskList,this);

        recyclerView.setAdapter(taskAdapter);
    }
}