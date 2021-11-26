package com.example.dictionaryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.Models.Meanings;
import com.example.dictionaryapp.R;
import com.example.dictionaryapp.ViewHolders.MeaningViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {

    private Context context;
    private List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @NotNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items , parent , false));

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MeaningViewHolder holder, int position) {
        holder.textView_PartsOfSpeech.setText("Parts Of Speech "+meaningsList.get(position).getPartOfSpeech());
        holder.recyclerView_Definition.setHasFixedSize(true);
        holder.recyclerView_Definition.setLayoutManager(new GridLayoutManager(context ,1));
        

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
