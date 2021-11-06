package com.example.dictionaryapp;

import android.content.Context;

import com.example.dictionaryapp.Models.ApiResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }
    public void getWordMeaning(OnFetchDataListener listener , String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<ApiResponce>> call = callDictionary.callMeanings(word);
    }

    public interface CallDictionary{
        @GET("entries/en/{word}")
        Call<List<ApiResponce>> callMeanings(
                @Path("word") String word
        );
    }
}
