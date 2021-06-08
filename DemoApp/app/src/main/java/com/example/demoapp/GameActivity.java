package com.example.demoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;

public class GameActivity extends AppCompatActivity {

    int playerTurn = 0;
    TextView textView;

    int gameState[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    int allWinState[][] = {
            {0,1,2} , {0,3,6} , {2,5,8} ,
            {1,4,7} , {0,4,8}, {2,4,6},
            {3,4,5},{6,7,8}
    };

    SharedPreferences sharedPreferences;
    String player0 , player1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        player0 = sharedPreferences.getString("player1","first player");
        player1 = sharedPreferences.getString("player2","second player");


        textView = findViewById(R.id.textViewPlayerName);
        textView.setText(player0+"'Turn");

    }
    public  void playGameClicked(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void playerTapped(View view){
        ImageView imageView = (ImageView) view;
        int tag = Integer.parseInt(imageView.getTag().toString());


        Toast.makeText(getApplicationContext(),"Tapped" + tag,Toast.LENGTH_LONG).show();

        //updating the game state array
        gameState[tag] = playerTurn;


        if(playerTurn == 0){
            imageView.setImageResource(R.drawable.img_o);
            playerTurn = 1;
            textView.setText(player1+"'s Turn");
        }else if(playerTurn == 1){
            imageView.setImageResource(R.drawable.img_x);
            playerTurn = 0;
            textView.setText(player0+"'s Turn");


        }

        //checking the one of win state with matching game state array
        for(int[] oneWinState : allWinState){
            if(gameState[oneWinState[0]] != -1
                    && gameState[oneWinState[0]] == gameState[oneWinState[1]]
                    && gameState[oneWinState[1]] == gameState[oneWinState[2]]){

                // checking who won
                if(gameState[oneWinState[0]] == 0){
                    // 0 wins
                    textView.setText(player0+" wins");
                    popupDialog(player0);
                }else{
                    textView.setText(player1+" wins");
                    popupDialog(player1);
                }


            }

        }
    }

    private void popupDialog(String playerName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Congratulations You Win").setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();;
    }

    public void resetGame(View view){
        for(int i =0 ;i<gameState.length;i++){
            gameState[i] = -1;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        textView.setText("Person Turn");
    }

}