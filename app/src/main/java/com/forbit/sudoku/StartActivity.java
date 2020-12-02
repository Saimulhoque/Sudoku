package com.forbit.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton btnstart,btndailysudoku,btncustom,btnstats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnstart = findViewById(R.id.startgame);
        btndailysudoku = findViewById(R.id.dailysudoku);
        btncustom = findViewById(R.id.customsudoku);
        btnstats = findViewById(R.id.statistics);

        btnstart.setOnClickListener(this);
        btndailysudoku.setOnClickListener(this);
        btncustom.setOnClickListener(this);
        btnstats.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v==btnstart){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }else if (v==btndailysudoku){
            Toast.makeText(this, "Sorry, You Don't Have Any Daily Sudoku!!", Toast.LENGTH_SHORT).show();
        }else if (v==btncustom){
            Toast.makeText(this, "After Play 10 Games It Will Be Enabled!!", Toast.LENGTH_SHORT).show();
        }else if (v==btnstats){
            Toast.makeText(this, "Your Statistics Is Empty!!", Toast.LENGTH_SHORT).show();
        }
    }
}