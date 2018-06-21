package com.example.administrateur.exo_formulaire;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class lister_activity extends AppCompatActivity {
    //TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);

        List<String> personnes = new ArrayList<>();
        DAOImpl dao =new DAOImpl(lister_activity.this);
        for(Personne p : dao.lister()) {
            personnes.add(p.getPrenom());
            //  tv.setText(texte);
        }
        ListView liste = (ListView) findViewById(R.id.liste);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(lister_activity.this, android.R.layout.simple_list_item_1, personnes);

        liste.setAdapter(arrayAdapter);


       //tv = (TextView) findViewById(R.id.edit);

        //String texte ="";

       // for(Personne p : dao.lister()){
         //   texte = texte + (p.getPrenom() + " " + p.getAge() + "\n");
          //  tv.setText(texte);
        //}
    }

}
