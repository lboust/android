package com.example.administrateur.exo_formulaire;

import android.content.Context;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DAOImpl dao = new DAOImpl(MainActivity.this);

        //dao.ajouter(new Personne("Muxette", 1));
        //dao.ajouter(new Personne("Muxu", 3));
        //dao.lister();

        //for(Personne p : dao.lister()){
        //    Log.i("Personne", p.getPrenom());
        //}

        Button boutonAjouter = (Button) findViewById(R.id.ajouter);
        boutonAjouter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AjouterActivity.class);
                                       // Bundle data = new Bundle();
                                        //data.putSerializable("personne", new Personne("Lorraine", 23));
                                        //intent.putExtra("data", data);
                startActivity(intent);
            }
        });
        Button boutonLister = (Button) findViewById(R.id.lister);
        boutonLister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, lister_activity.class);

                startActivity(intent);
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
