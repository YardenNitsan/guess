package com.example.ahah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {
    TextView b;
    Button r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        b= findViewById(R.id.boom);
        r= findViewById(R.id.r);
        b.setText("You Got It Right!!!!");
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Win.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}