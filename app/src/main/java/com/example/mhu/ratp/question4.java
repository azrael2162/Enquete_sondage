package com.example.mhu.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question4 extends AppCompatActivity implements View.OnClickListener{
    private Button btSuivant ;
    private RadioGroup rgAmbiance, rgMateriel;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        this.nom = getIntent().getStringExtra("nom");
        this.btSuivant = (Button)findViewById(R.id.idSuivant4);
        this.rgAmbiance = (RadioGroup)findViewById(R.id.idtarif);
        this.rgMateriel = (RadioGroup)findViewById(R.id.idauto);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant4)
        {
            String suiva ="tarif";
            String auto ="automatisation";
            int scoreAAA=0, scoreBdeee=0;

            //on calcule les scores
            switch (this.rgAmbiance.getCheckedRadioButtonId())
            {
                case R.id.ids1 : scoreAAA = 6; break;
                case R.id.ids2 : scoreAAA = 12;break;
                case R.id.ids3 : scoreAAA = 16;break;
            }
            switch (this.rgMateriel.getCheckedRadioButtonId())
            {
                case R.id.idau1 :  scoreBdeee = 6;break;
                case R.id.idau2 : scoreBdeee = 12;break;
                case R.id.idau3 : scoreBdeee = 16;break;
            }

            //insertion des scores dans la Hashmap
            Enquete.ajouterReponse(this.nom,suiva, scoreAAA );
            Enquete.ajouterReponse(this.nom,auto, scoreBdeee );
            //On passe à la page 3
            Intent unIntent = new Intent(this,conclusion.class);
            unIntent.putExtra("nom",this.nom);
            startActivity(unIntent);
        }
    }
}
