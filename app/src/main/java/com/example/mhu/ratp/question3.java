package com.example.mhu.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class question3 extends AppCompatActivity implements View.OnClickListener{
    private Button btSuivant ;
    private RadioGroup rgAmbiance, rgBde;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        this.nom = getIntent().getStringExtra("nom");
        this.btSuivant = (Button)findViewById(R.id.idSuivant3);
        this.rgAmbiance = (RadioGroup)findViewById(R.id.idproprete);
        this.rgBde = (RadioGroup)findViewById(R.id.idservice);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant3)
        {
            String pror ="proprete";
            String serv ="service";
            int scoreAA=0, scoreBdee=0;

            //on calcule les scores
            switch (this.rgAmbiance.getCheckedRadioButtonId())
            {
                case R.id.ids1 : scoreAA = 6; break;
                case R.id.ids2 : scoreAA = 12;break;
                case R.id.ids3 : scoreAA = 16;break;
            }
            switch (this.rgBde.getCheckedRadioButtonId())
            {
                case R.id.idpe1 : scoreBdee = 6;break;
                case R.id.idpe2 : scoreBdee = 12;break;
                case R.id.idpe3 : scoreBdee = 16;break;
            }

            //insertion des scores dans la Hashmap
            Enquete.ajouterReponse(this.nom,serv, scoreAA );
            Enquete.ajouterReponse(this.nom,pror, scoreBdee );
            //On passe à la page 3
            Intent unIntent = new Intent(this,question4.class);
            unIntent.putExtra("nom",this.nom);
            startActivity(unIntent);
        }
    }
}
