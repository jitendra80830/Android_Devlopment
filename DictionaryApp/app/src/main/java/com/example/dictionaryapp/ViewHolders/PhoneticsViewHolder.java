package com.example.dictionaryapp.ViewHolders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class PhoneticsViewHolder extends RecyclerView.ViewHolder {
    public TextView textView_phonetic;
    public ImageView imageButton_audio;


    public PhoneticsViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_phonetic = itemView.findViewById(R.id.textView_phonetic);
        imageButton_audio = itemView.findViewById(R.id.imageButton_audio);
    }
}
