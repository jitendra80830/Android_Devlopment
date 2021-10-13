package com.example.quizme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quizme.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.cotent ,new HomeFragment());
        homeTrans.commit();

        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.home:
                        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
                        homeTrans.replace(R.id.cotent ,new HomeFragment());
                        homeTrans.commit();
                        //Toast.makeText(MainActivity.this ,"Home",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.rank:
                        FragmentTransaction rankTrans = getSupportFragmentManager().beginTransaction();
                        rankTrans.replace(R.id.cotent ,new LeaderboardFragment());
                        rankTrans.commit();
                        //Toast.makeText(MainActivity.this ,"Rank",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.wallet:
                        FragmentTransaction walletTrans = getSupportFragmentManager().beginTransaction();
                        walletTrans.replace(R.id.cotent ,new WalletFragment());
                        walletTrans.commit();
                        //Toast.makeText(MainActivity.this ,"Wallet",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.profile:
                        FragmentTransaction profileTrans = getSupportFragmentManager().beginTransaction();
                        profileTrans.replace(R.id.cotent ,new ProfilFragment());
                        profileTrans.commit();
                        //Toast.makeText(MainActivity.this ,"Profile",Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });




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