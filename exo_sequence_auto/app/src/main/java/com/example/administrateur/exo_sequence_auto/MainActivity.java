package com.example.administrateur.exo_sequence_auto;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView animation;
    Drawable[] tableau = new Drawable[4];
    Handler h = new Handler();
    Boolean isStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableau[0]=getResources().getDrawable(R.drawable.sequence0_360, getTheme());
        tableau[1]=getResources().getDrawable(R.drawable.sequence1_360, getTheme());
        tableau[2]=getResources().getDrawable(R.drawable.sequence2, getTheme());
        tableau[3]=getResources().getDrawable(R.drawable.sequence3_360, getTheme());
        final Button startstop = (Button) findViewById(R.id.button);
        animation=(ImageView) findViewById(R.id.image);

        startstop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!isStarted) {
                    startstop.setText("STOP");
                    isStarted=true;
                    new Thread(
                            new Runnable(){
                                int compteur = 0;
                                @Override
                                public void run(){
                                    while(isStarted){
                                   /* runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            tv.setText(String.valueOf(compteur++));
                                        }
                                    });*/
                                        h.post(new Runnable(){
                                            @Override
                                            public void run() {
                                                animation.setImageDrawable(tableau[compteur]);
                                                compteur++;
                                                compteur%=4;

                                            }
                                        });
                                        try {

                                            Thread.sleep(150);
                                        } catch (InterruptedException e){
                                            e.printStackTrace();
                                        }
                                    }

                                }
                            }
                    ).start();
                } else {
                    animation.setImageDrawable(tableau[0]);
                    isStarted = false;
                    startstop.setText("START");
                }


            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
