package com.example.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {

    TextView textView_PartsOfSpeech;
    RecyclerView recyclerView_Definition;
    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_PartsOfSpeech = itemView.findViewById(R.id.textView_PartsOfSpeech);
        recyclerView_Definition = itemView.findViewById(R.id.recyclerView_Definition);
    }
}
