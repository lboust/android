package com.example.administrateur.exo_formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjouterActivity extends AppCompatActivity {
    EditText editTextPrenom;
    EditText editTextAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        //Intent intent = getIntent();
        //Bundle data = intent.getBundleExtra("data");
        //Personne p = (Personne)data.getSerializable("personne");
        //Log.i ("personne", p.getPrenom());
        //finish();

        editTextPrenom = findViewById(R.id.prenom);
        editTextAge = findViewById(R.id.age);
        Button boutonAjouter = (Button) findViewById(R.id.ok);
        boutonAjouter.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               String prenom = editTextPrenom.getText().toString();
               String age = editTextAge.getText().toString();
               //Log.i("prenom:", prenom);
               Personne personne = new Personne(prenom, Integer.parseInt(age));
               DAOImpl dao =new DAOImpl(AjouterActivity.this);
               dao.ajouter(personne);
               for(Personne p : dao.lister()){
                   Log.i("personne :", p.getPrenom());
               }
           }
        });
        /*Button boutonRetour = (Button) findViewById(R.id.retour);
        boutonRetour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AjouterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/
    }

}
