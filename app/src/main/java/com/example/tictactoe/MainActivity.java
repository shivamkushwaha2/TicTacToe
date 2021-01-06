package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    boolean check = true;

    boolean check1 = true;
    int [][] winpositions = {{0,1,2}, {3,4,5},{6,7,8}, {0,3,6},{1,4,7}, {2,5,8,}, {0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());


        if (gamestate[tappedImage]==2 && check == true)
        {
            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if( gamestate[0] != 2 && gamestate[1] != 2
                    && gamestate[2] != 2 && gamestate[3] != 2 &&gamestate[4] != 2
                    && gamestate[5] != 2 && gamestate[6] != 2 && gamestate[7] != 2 && gamestate[8] != 2)
            {
                Button b2 = findViewById(R.id.b1);
                b2.setVisibility(View.VISIBLE);
                TextView status = findViewById(R.id.status);
                status.setText("DRAW");
                check1 = false;
            }


            if (activeplayer == 0)
            {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                if(check1==true) {
                    TextView status = findViewById(R.id.status);
                    status.setText("Player2-It's your turn");
                }
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                if(check1==true) {
                    TextView status = findViewById(R.id.status);
                    status.setText("Player1-It's your turn");
                }
            }

            img.animate().translationYBy(1000f).setDuration(200);


        }
        int [] ids = new int [] {R.id.imageView0, R.id.imageView1, R.id.imageView2, R.id.imageView3,
                R.id.imageView4, R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8};

        for(int[] winposition: winpositions){
            if(gamestate[winposition[0]] == gamestate[winposition[1]] &&
                    gamestate[winposition[1]] == gamestate[winposition[2]] &&
            gamestate[winposition[0]] !=2){
                String win;
                check=false;

                if(gamestate[winposition[0]]==0){
                    win = "Player1 has won";
                    Button b2 = findViewById(R.id.b1);
                    b2.setVisibility(View.VISIBLE);
                    b2.setText("PLAY AGAIN");

                        ImageView img1 = findViewById(ids[winposition[0]]);
                        ImageView img2 = findViewById(ids[winposition[1]]);
                        ImageView img3 = findViewById(ids[winposition[2]]);
                        img1.setColorFilter(getResources().getColor(R.color.purple_700));
                        img2.setColorFilter(getResources().getColor(R.color.purple_700));
                        img3.setColorFilter(getResources().getColor(R.color.purple_700));


                }
                else{
                    win ="Player2 has won";
                    Button b2 = findViewById(R.id.b1);
                    b2.setVisibility(View.VISIBLE);
                    b2.setText("PLAY AGAIN");

                        ImageView img1 = findViewById(ids[winposition[0]]);
                        ImageView img2 = findViewById(ids[winposition[1]]);
                        ImageView img3 = findViewById(ids[winposition[2]]);
                        img1.setColorFilter(getResources().getColor(R.color.purple_700));
                        img2.setColorFilter(getResources().getColor(R.color.purple_700));
                        img3.setColorFilter(getResources().getColor(R.color.purple_700));


                }
                TextView status = findViewById(R.id.status);
                status.setText(win);

            }

        }
    }
    public void btnTap(View view){

        gamereset(view);
    }
    public void gamereset(View view) {
    activeplayer = 0;
    check=true;
    check1=true;
    for(int i=0; i<gamestate.length; i++){
        gamestate[i]=2;
    }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView1)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView2)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView3)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView4)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView5)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView6)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView7)).clearColorFilter();
        ((ImageView)findViewById(R.id.imageView8)).clearColorFilter();

        TextView status = findViewById(R.id.status);
        status.setText("Player1-It's your turn");
        Button b2 = findViewById(R.id.b1);
        b2.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
