package com.example.tictactao;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    // 0=X
    // 1=O
    int activeplayer = 0;

    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    // 0 - x
    // 1 - o
    // 2 - null

    int[][] winposition = {{0,1,2},{3,4,5},{6,7,8},
                           {0,3,6},{1,4,7},{2,5,8},
                           {0,4,8},{2,4,6}};

    public void tap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive){
            gamereset (view);
        }
        if(gamestate[tappedImage] == 2) {
            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.captains);                   //0 iron     ss cap
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Iron man turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.ironlogo);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Captain turn - Tap to play");
            }


            img.animate().translationYBy(1000f).setDuration(300);

        }
        // cheack for winner
        for (int[] winposition: winposition){
            if(gamestate[winposition[0]] == gamestate[winposition[1]] &&
                  gamestate[winposition[1]] == gamestate[winposition[2]] &&
                  gamestate[winposition[0]] != 2){
      // find who
              String winnerStr;
              gameActive = false;
              if (gamestate[winposition[0]] == 0){
                  winnerStr = "Captain has won";
              }
              else {
                  winnerStr = "Iron man has won";
              }

              TextView status = findViewById(R.id.status);
              status.setText(winnerStr);
          }


        }


    }

    public void gamereset(View view)
    {
        gameActive = true;
        activeplayer = 0;
        for (int i=0; i<gamestate.length; i++)
        {
            gamestate[i]= 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("Captain turn - Tap to play");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}