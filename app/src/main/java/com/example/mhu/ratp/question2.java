package com.example.mhu.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question2 extends AppCompatActivity implements View.OnClickListener{
    private Button btSuivant ;
    private RadioGroup rgAmbiance, rgBde, rgMateriel;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        this.nom = getIntent().getStringExtra("nom");
        this.btSuivant = (Button)findViewById(R.id.idSuivant3);
        this.rgAmbiance = (RadioGroup)findViewById(R.id.idponctuel);
        this.rgBde = (RadioGroup)findViewById(R.id.idserviable);
        this.rgMateriel = (RadioGroup)findViewById(R.id.idMateriel);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant3)
        {
            String amb ="ponctuel";
            String bde ="serviable";
            int scoreA=0, scoreBde=0, scoreMat= 0;

            //on calcule les scores
            switch (this.rgAmbiance.getCheckedRadioButtonId())
            {
                case R.id.idam1 : scoreA = 6; break;
                case R.id.idam2 : scoreA = 12;break;
                case R.id.idam3 : scoreA = 16;break;
            }
            switch (this.rgBde.getCheckedRadioButtonId())
            {
                case R.id.idbde1 : scoreBde = 6;break;
                case R.id.idbde2 : scoreBde = 12;break;
                case R.id.idbde3 : scoreBde = 16;break;
            }

            //insertion des scores dans la Hashmap
            Enquete.ajouterReponse(this.nom,amb, scoreA );
            Enquete.ajouterReponse(this.nom,bde, scoreBde );
            //On passe à la page 3
            Intent unIntent = new Intent(this,question3.class);
            unIntent.putExtra("nom",this.nom);
            startActivity(unIntent);
        }
    }
}
