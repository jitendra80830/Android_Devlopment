package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskRowHolder> {

    ArrayList<Task> taskList;
    Context context;

    public TaskAdapter(ArrayList<Task> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public TaskRowHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //taken an instance of row layout
        View view = LayoutInflater.from(context).inflate(R.layout.row_holder,parent,false);
        return new TaskRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskAdapter.TaskRowHolder holder, int position) {
        //binding the value to the TaskRowHolder class variable
        holder.textViewTitle.setText(taskList.get(position).getTitle());
        holder.textViewDesc.setText(taskList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskRowHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle,textViewDesc;

        public TaskRowHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            //attaching the textview to this class variable
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
        }
    }
}
