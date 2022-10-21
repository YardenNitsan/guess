package com.example.ahah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahah.OneToFifty;
import com.example.ahah.OneToHundred;
import com.example.ahah.OneToTen;

public class MainActivity extends AppCompatActivity{
    TextView StartText;
    EditText name;
    Button save;
    AlertDialog.Builder alertBuilder;
    SharedPreferences sharedPreferences;
    private String NamePreference = "myPref";
    private String NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.Name);
        save = findViewById(R.id.btnSave);
        sharedPreferences = getSharedPreferences(NamePreference, MODE_PRIVATE);
        initAlert();
        StartText = findViewById(R.id.StartText);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(NAME,name.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this,"saved", Toast.LENGTH_SHORT ).show();
            }
        });
    }

    protected void initAlert() {
        alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Transition");
        alertBuilder.setMessage("Are you sure you want to move on?");
    }

    public void openOneToTen() {
        Intent intent = new Intent(this, OneToTen.class);
        startActivity(intent);
    }

    public void openOneToFifty() {
        Intent intent = new Intent(this, OneToFifty.class);
        startActivity(intent);
    }

    public void openOneToHundred() {
        Intent intent = new Intent(this, OneToHundred.class);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        int id = item.getItemId();
        switch(id) {
            case R.id.ONETOTEN:
                alertBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Succeed move",Toast.LENGTH_LONG).show();
                        openOneToTen();
                    }
                });
                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Cancled",Toast.LENGTH_LONG).show();
                    }
                });
                break;

            case R.id.ONETOFIFTY:
                alertBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Succeed move",Toast.LENGTH_LONG).show();
                        openOneToFifty();
                    }
                });
                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Cancled",Toast.LENGTH_LONG).show();
                    }
                });
                break;

            case R.id.ONETOHUNDRED:
                alertBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Succeed move",Toast.LENGTH_LONG).show();
                        openOneToHundred();
                    }
                });
                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Cancled",Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
        alertBuilder.create().show();
        return true;
    }
}