package com.example.administrateur.exo_threadui;

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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv = (TextView) findViewById(R.id.edit);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //tv.setText(String.valueOf(compteur++));
                new Thread(
                        new Runnable(){
                            int compteur = 0;
                            @Override
                            public void run(){
                                while(true){
                                   /* runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            tv.setText(String.valueOf(compteur++));
                                        }
                                    });*/
                                   h.post(new Runnable(){
                                    @Override
                                    public void run() {
                                        tv.setText(String.valueOf(compteur++));
                                    }
                                });
                                    try {
                                        Thread.sleep(20);
                                    } catch (InterruptedException e){
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }
                ).start();
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
