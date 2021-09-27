package com.example.quizme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quizme.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        ArrayList<CategoryModel> categories = new ArrayList<>();

        categories.add(new CategoryModel("","Mathematics","https://static.vecteezy.com/system/resources/previews/000/502/111/original/mathematics-icon-design-vector.jpg"));
        categories.add(new CategoryModel("","Science","https://static.vecteezy.com/system/resources/previews/000/502/111/original/mathematics-icon-design-vector.jpg"));
        categories.add(new CategoryModel("","History","https://static.vecteezy.com/system/resources/previews/000/502/111/original/mathematics-icon-design-vector.jpg"));
        categories.add(new CategoryModel("","Languages","https://static.vecteezy.com/system/resources/previews/000/502/111/original/mathematics-icon-design-vector.jpg"));
        categories.add(new CategoryModel("","Puzzle","https://static.vecteezy.com/system/resources/previews/000/502/111/original/mathematics-icon-design-vector.jpg"));
        categories.add(new CategoryModel("","Drama","https://static.vecteezy.com/system/resources/previews/000/502/111/original/mathematics-icon-design-vector.jpg"));

        CategoryAdapter adapter = new CategoryAdapter(this , categories);
        binding.catogeryList.setLayoutManager(new GridLayoutManager(this , 2));
        binding.catogeryList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.wallet){
            Toast.makeText(this , "Wallet is Clicked" ,Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}