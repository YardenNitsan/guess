package com.example.ahah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahah.MainActivity;
import com.example.ahah.Win;

import java.util.Random;

public class OneToTen extends AppCompatActivity {
    EditText write;
    TextView guess,tv_name;
    Button Ok;
    TextView right;
    Button Back, logOut;
    int turn;
    private String NamePreference = "myPref";
    private String NAME = "name";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_ten);
        write = findViewById(R.id.writing);
        guess = findViewById(R.id.guess);
        Ok = findViewById(R.id.OK);
        right = findViewById(R.id.rightGuess);
        Back = findViewById(R.id.back);
        logOut = findViewById(R.id.LogOut);
        tv_name = findViewById(R.id.tv_name);
        sharedPreferences = getSharedPreferences(NamePreference,MODE_PRIVATE);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
        String name = sharedPreferences.getString(NAME, "");
        tv_name.setText(name);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(OneToTen.this, "Log out successfuly", Toast.LENGTH_SHORT).show();
                openMain();
            }
        });
        Random rand = new Random();
        int r = rand.nextInt(11);
        right.setText(""+r);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn = Integer.parseInt(write.getText().toString());
                if(turn==r) {
                    OpenWin();
                }
                else{
                    Toast.makeText(OneToTen.this,"NO",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void OpenWin(){
        Intent intent = new Intent(OneToTen.this, Win.class);
        startActivity(intent);
    }
    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}