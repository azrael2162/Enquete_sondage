package com.example.mhu.ratp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class conclusion extends AppCompatActivity {
    private String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion);
        this.nom = getIntent().getStringExtra("nom");
        Enquete.getLaMoyenneCandidat(this.nom);
        Toast.makeText(this, "La moyenne est de  : "+Enquete.getLaMoyenneCandidat(this.nom),
                Toast.LENGTH_LONG).show();
    }
}
