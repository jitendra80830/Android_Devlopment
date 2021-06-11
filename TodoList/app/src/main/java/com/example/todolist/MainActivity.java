package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

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


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


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

                                String title = editTextTitle.getText().toString();
                                String desc = editTextDescription.getText().toString();

                                int id = (int)(System.currentTimeMillis()/1000);

                                Task task = new Task(title,desc);
                                task.setId(id);

                                //new TaskHandler(MainActivity.this).createTask(
                                //        new Task(editTextTitle.getText().toString()
                                //                ,editTextDescription.getText().toString()));
                                //TODO add the task

                                FirebaseDatabase.getInstance().getReference("paths").child(String.valueOf(id)).
                                        setValue(task)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull @NotNull com.google.android.gms.tasks.Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(MainActivity.this
                                                    ,"Task Added Successfully"
                                                    ,Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });

                            }
                        }).show();

            }
        });
        ItemTouchHelper.SimpleCallback itemCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                //new TaskHandler(MainActivity.this).deleteTask(
                // taskList.get(viewHolder.getAdapterPosition()).getId());

                //TODO delete a task
                FirebaseDatabase.getInstance().getReference("paths")
                        .child(taskList.get(viewHolder.getAdapterPosition()).getId() + "").removeValue();


                //taskList.remove(viewHolder.getAdapterPosition());
                //taskAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        populateTask();
    }

    private void populateTask() {

        //taskList = new TaskHandler(this).getAllTask();
        //Todo fetch all the task
        FirebaseDatabase.getInstance().getReference("paths").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                taskList.clear();
                for(DataSnapshot data : snapshot.getChildren()){
                    Task task = data.getValue(Task.class);
                    taskList.add(task);

                }

                taskAdapter = new TaskAdapter(taskList,MainActivity.this);

                recyclerView.setAdapter(taskAdapter);

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }
}