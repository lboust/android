package com.example.administrateur.exo_formulaire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrateur on 15/06/2018.
 */

public class DAOImpl extends SQLiteOpenHelper implements DAO {
    public DAOImpl(Context context) {
        super(context, "personne.db", null, 1);
        //this.getWritableDatabase().execSQL("Drop table personnes");
        this.getWritableDatabase().execSQL("Create table if not exists personnes (prenom string, age int);");
    }

    @Override
    public void ajouter(Personne personne) {
        SQLiteDatabase db = this.getWritableDatabase();
        //préparer les attributs de table
        ContentValues cv = new ContentValues();
        cv.put("prenom", personne.getPrenom());
        cv.put("age", personne.getAge());
        db.insert("personnes", null, cv);
    }

    @Override
    public List<Personne> lister() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Personne> liste = new ArrayList<Personne>();
        Cursor curseur = db.rawQuery("select * from personnes", null);
        curseur.moveToFirst();
        while(!curseur.isAfterLast()){
            String prenom = curseur.getString(curseur.getColumnIndex("prenom"));
            int age = curseur.getInt(curseur.getColumnIndex("age"));
            liste.add(new Personne(prenom, age));
            curseur.moveToNext();
        }
        curseur.close();
        return liste;
    }

    @Override
    public void modifier(Personne personne) {

    }

    @Override
    public void supprimer(Personne personne) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Create table if not exists personnes ( prenom string, age int);");

    }
}


