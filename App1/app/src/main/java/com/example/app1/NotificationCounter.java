package com.example.app1;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NotificationCounter {

    private TextView notificationNumber;
    private final int MAX_NUMBER =99;
    private int notification_number_counter =1;

    public NotificationCounter(View view){
        notificationNumber = view.findViewById(R.id.notificationNo);
    }
    public void increaseNumber(){
        notification_number_counter++;

        if(notification_number_counter>MAX_NUMBER){
            Log.d("counter","Maximum Number Reached");
        }else {
            notificationNumber.setText(String.valueOf(notification_number_counter));
        }

    }

}
