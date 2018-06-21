package com.example.administrateur.exo_compteur_socket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ServerSocket server = new ServerSocket(3333);
                            Socket canal = server.accept();
                            OutputStream echange = canal.getOutputStream();
                            int sequence = 0;
                            Gson gson = new Gson();
                            while(true){
                                Compteur compteur = new Compteur();
                                compteur.setValue(sequence++);
                                String data =gson.toJson(compteur);

                                echange.write((data +"\r\n").getBytes());
                                echange.flush();
                                Thread.sleep(200);
                            }

                            //echange.close();
                            //server.close();


                        } catch(IOException e){
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                /*
/*
                //mettre en place le filtrage du broadcast
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("NEWVALUE");
                registerReceiver(new RetourCompteur(), intentFilter);

                //préparer l'intention d'échange entre la classe Main et le service
                Intent intent = new Intent(MainActivity.this, Service_compteur.class);
                Bundle data = new Bundle();
                //valeur initale donnée au service
                data.putInt("compteur", 10);
                //envoyer le compteur
                intent.putExtras(data);
                //démarrer le service
                startService(intent);*/

            }
        });
    }
/*
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
    //traitement de retour de data via BroadCast
    class RetourCompteur extends BroadcastReceiver{
        @Override
        public void onReceive(Context contex, Intent intent){
            tv = (TextView) findViewById(R.id.edit);
            int compteur =intent.getIntExtra("compteur", 0);

            tv.setText(String.valueOf(compteur));

        }
    }*/
}
