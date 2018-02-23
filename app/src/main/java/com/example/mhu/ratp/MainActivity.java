package com.example.mhu.ratp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView11, imageView22, imageView33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageView11 = (ImageView)findViewById(R.id.imageView1);
        this.imageView22 = (ImageView)findViewById(R.id.imageView2);
        this.imageView33 = (ImageView)findViewById(R.id.imageView3);

        this.imageView11.setOnClickListener(this);
        this.imageView22.setOnClickListener(this);
        this.imageView33.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageView1) {
            Intent unIntent = new Intent(this,page2.class);
            startActivity(unIntent);
        }if (view.getId() == R.id.imageView2){
            Intent unIntent = new Intent(this,page3.class);
            startActivity(unIntent);
        }if (view.getId() == R.id.imageView3){
            Intent unIntent = new Intent(this,page4.class);
            startActivity(unIntent);
        }
    }
}
