package com.example.dictionaryapp;

import com.example.dictionaryapp.Models.ApiResponce;

public interface OnFetchDataListener {
    void onFetchData(ApiResponce apiResponce , String message);
    void onError(String message);
}
