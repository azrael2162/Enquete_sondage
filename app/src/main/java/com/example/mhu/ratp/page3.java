package com.example.mhu.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class page3 extends AppCompatActivity implements View.OnClickListener {
    private EditText nom,prenom,profession;
    private Spinner frequence,age;
    private Button valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.activity_page2);
        this.prenom = (EditText)findViewById(R.id.editText);
        this.profession = (EditText)findViewById(R.id.editText3);
        this.nom = (EditText)findViewById(R.id.editText2);
        this.frequence = (Spinner) findViewById(R.id.spinner);
        this.age = (Spinner) findViewById(R.id.spinner2);
        this.valider = (Button) findViewById(R.id.buton);

        ArrayList<String> lesfrequ = new ArrayList<String>();
        lesfrequ.add("0-5");
        lesfrequ.add("5-10");
        lesfrequ.add("10-15");
        lesfrequ.add("15-20");
        //declaration d'un Array Adapter : formatage
        ArrayAdapter unAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, lesfrequ);
        this.frequence.setAdapter(unAdapter);//changement de l'adapter

        ArrayList<String> lage = new ArrayList<String>();
        String t ="";
        for (int i=18; i<=99; i++){
            lage.add(t ="" +i);
        }


        //declaration d'un Array Adapter : formatage
        ArrayAdapter unAdapterr = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, lage);
        this.age.setAdapter(unAdapterr);//changement de l'adapter

        this.valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.buton){
            String prenom = this.prenom.getText().toString();
            String nom = this.nom.getText().toString();
            String frequence = this.frequence.getSelectedItem().toString();
            String age = this.age.getSelectedItem().toString();

            Candidat unCandidat = new Candidat(prenom,nom,frequence,age);
            Enquete.ajouterCandidat(unCandidat);
            Intent unIntent = new Intent(this,question.class);
            startActivity(unIntent);
        }
    }
}



