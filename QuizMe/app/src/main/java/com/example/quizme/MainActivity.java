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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.startapp.sdk.adsbase.StartAppSDK;

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





        MobileAds.initialize(this, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);


        binding.adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
                Toast.makeText(MainActivity.this , "ads Loaded",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                binding.adView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        AdSize adSize = new AdSize(300, 50);





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