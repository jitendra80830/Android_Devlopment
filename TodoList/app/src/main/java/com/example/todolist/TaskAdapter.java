package com.example.todolist;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskRowHolder> {

    @NonNull
    @NotNull
    @Override
    public TaskRowHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskAdapter.TaskRowHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TaskRowHolder extends RecyclerView.ViewHolder{

        public TaskRowHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
        }
    }
}
