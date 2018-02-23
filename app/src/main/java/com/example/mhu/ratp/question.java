package com.example.mhu.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question extends AppCompatActivity implements View.OnClickListener{
    private String nom;
    private Button btSuivant ;
    private RadioGroup rgPedagogie, rgAdministration, rgEnseignement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        this.nom = getIntent().getStringExtra("nom");

        Toast.makeText(this, "Bienvenue : "+this.nom,
                Toast.LENGTH_SHORT).show();
        this.btSuivant = (Button)findViewById(R.id.idSuivant2);
        this.rgAdministration = (RadioGroup)findViewById(R.id.idSecurite);
        this.rgPedagogie = (RadioGroup)findViewById(R.id.idMateriel);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant2)
        {
            String admin ="Securite";
            String ens ="Materiel";
            int scoreA=0, scoreP=0, scoreE= 0;

            //on calcule les scores
            switch (this.rgAdministration.getCheckedRadioButtonId())
            {
                case R.id.ida1 : scoreA = 6; break;
                case R.id.ida2 : scoreA = 12;break;
                case R.id.ida3 : scoreA = 16;break;
            }
            switch (this.rgPedagogie.getCheckedRadioButtonId())
            {
                case R.id.idr1 : scoreP = 6;break;
                case R.id.idr2 : scoreP = 12;break;
                case R.id.idr3 : scoreP = 16;break;
            }

            //insertion des scores dans la Hashmap
            Enquete.ajouterReponse(this.nom,admin, scoreA );
            Enquete.ajouterReponse(this.nom,ens, scoreP );
            //On passe à la page 3
            Intent unIntent = new Intent(this,question2.class);
            unIntent.putExtra("nom",this.nom);
            startActivity(unIntent);
        }
    }
}
