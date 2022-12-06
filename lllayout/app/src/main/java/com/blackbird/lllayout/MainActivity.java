  package com.blackbird.lllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


  public class MainActivity extends AppCompatActivity {
      //0 - x
      //1 - 0
      boolean gameactive = true ;
      String winner = "" ;
      int activeplayer = 0  ;
      int []gamestate ={2,2,2,2,2,2,2,2,2};
      int [][]winpositions={{0,1,2},{3,4,5},{6,7,8}
                          ,{0,3,6},{1,4,7},{2,5,8}
                          ,{0,4,8},{2,4,6}};


      public  void   game_rest(View view)
      {
          gameactive = true ;
          activeplayer = 0 ;
          for (int i = 0; i < 9; i++) {
              gamestate[i]=2 ;

          }
          TextView restrt = findViewById(R.id.restart);
          restrt.setText("");

          TextView status = findViewById(R.id.status);
          status.setText("X player turn ");


          ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);









      }


    public void  taptap(View view)
    {
        if(!gameactive)
        {
            game_rest(view);
            return ;
        }




        ImageView img = (ImageView) view ;
        int tapped_img = Integer.parseInt(img.getTag().toString());
        if ( gamestate[tapped_img]==2&&gameactive) {
            gamestate[tapped_img] = activeplayer ;
            img.setTranslationY(-180f);
            TextView status = findViewById(R.id.status);


            if(activeplayer==0)
            {

                activeplayer=1;
            img.setImageResource(R.drawable.xx);
            winner = "X";

                status.setText("O Player turn");

            }


            else
            {

                activeplayer = 0 ;
                img.setImageResource(R.drawable.o);
                winner = "O";


                status.setText("X Player turn");
            }

            img.animate().translationYBy(180f).setDuration(350);
            //Checks if someone has won


            for (int [] winposition:winpositions) {
                //checking if same values are present in win position indexs
                if(gamestate[winposition[0]]==gamestate[winposition[1]]&&gamestate[winposition[0]]==gamestate[winposition[2]]&&gamestate[winposition[0]]!=2)
                {
                    status.setText(  winner + " WINNER ");
                    TextView restrt = findViewById(R.id.restart);
                    restrt.setText("TAP ANYWHERE ON GRID TO  RESTART");

                    gameactive = false ;

                }

            }




        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}