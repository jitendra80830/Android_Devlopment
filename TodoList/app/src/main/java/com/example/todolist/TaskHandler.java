package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TaskHandler extends DatabaseHelper{
    public TaskHandler(Context context) {
        super(context);
    }
    public boolean createTask(Task task){
        ContentValues values = new ContentValues();
        values.put("title",task.getTitle());
        values.put("description",task.getDescription());
        SQLiteDatabase db = this.getWritableDatabase();
        boolean isSuccess = db.insert("tasks",null,values) > 0;
        db.close();
        return isSuccess;
    }
    public ArrayList<Task> getAllTask(){
        ArrayList<Task> taskList = new ArrayList<Task>();
        String query = "SELECT * FROM tasks";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int taskID = cursor.getInt(cursor.getColumnIndex("task_id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String description = cursor.getString(cursor.getColumnIndex("description"));

                Task task = new Task(title,description);

                task.setId(taskID);
                taskList.add(task);

            }while(cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return taskList;
    }
}
