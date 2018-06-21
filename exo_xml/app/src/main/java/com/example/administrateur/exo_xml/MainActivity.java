package com.example.administrateur.exo_xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;


import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try{
            //instancier le parseur
            SAXParser saxParser =saxParserFactory.newSAXParser();
            //donner le traitement au parseur
            //donner le fichier xml à parser
            Log.i("**", new File(".").getAbsolutePath());
            //parseur existant


            saxParser.parse(new FileInputStream("/data/user/0/document.xml"), new TraitementXML());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
