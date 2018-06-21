package com.example.administrateur.exo_compteur_socket;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class Service_compteur extends Service {
    Handler h = new Handler();
    public Service_compteur() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flag, int startId){
        //récupérer  la valeur initiale du compteur
        Bundle data =intent.getExtras();
        int compteur = data.getInt("compteur");
        new Thread(
                new Runnable(){
                    Intent intent2 = new Intent();

                    int compteur = 0;
                    @Override
                    public void run(){
                        intent2.setAction("NEWVALUE");
                        while(true){
                            h.post(new Runnable(){
                                @Override
                                public void run() {
                                    //Log.i("compteur", String.valueOf(compteur));
                                    compteur++;
                                    //diffuser la nouvelle valeur
                                    intent2.putExtra("compteur", compteur);
                                    sendBroadcast(intent2);

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


        return super.onStartCommand(intent, flag, startId);
    }
}
