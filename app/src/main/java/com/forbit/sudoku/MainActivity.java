package com.forbit.sudoku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.forbit.HelpFragment;
import com.forbit.sudoku.customView.SudokuView;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainActivityListener, SudokuView.SudokuListener {

    LinearLayout game, clear, hint;
    private MaterialButton btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private SudokuView sudokuView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sudokuView = findViewById(R.id.sudokuview);
        sudokuView.setListener(this);

        btnOne = findViewById(R.id.one);
        btnTwo = findViewById(R.id.two);
        btnThree = findViewById(R.id.three);
        btnFour = findViewById(R.id.four);
        btnFive = findViewById(R.id.five);
        btnSix = findViewById(R.id.six);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        game = findViewById(R.id.game);
        clear = findViewById(R.id.clear);
        hint = findViewById(R.id.hint);

        game.setOnClickListener(this);
        clear.setOnClickListener(this);
        hint.setOnClickListener(this);

        Log.d("HHHHH", AppPreference.getInstance(this).getFinalArr() + "");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mainmenu:
                super.onBackPressed();
                break;
            case R.id.help:
                break;
            case R.id.settings:
                SettingsFragment settingsFragment = new SettingsFragment();
                settingsFragment.setCancelable(false);
                settingsFragment.show(getSupportFragmentManager(), "jkbkjdfkjhd");
                break;
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.forbitbd.keywordgenerator&hl=en");
                startActivity(Intent.createChooser(sharingIntent, "Tag Tube"));
                break;
            case R.id.exit:
                finishAffinity();
                break;

            case R.id.screen_mode:

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        if (view == btnOne) {
            this.sudokuView.setValue(1);
        } else if (view == btnTwo) {
            this.sudokuView.setValue(2);
        } else if (view == btnThree) {
            this.sudokuView.setValue(3);
        } else if (view == btnFour) {
            this.sudokuView.setValue(4);
        } else if (view == btnFive) {
            this.sudokuView.setValue(5);
        } else if (view == btnSix) {
            this.sudokuView.setValue(6);
        } else if (view == btnSeven) {
            this.sudokuView.setValue(7);
        } else if (view == btnEight) {
            this.sudokuView.setValue(8);
        } else if (view == btnNine) {
            this.sudokuView.setValue(9);
        } else if (view == game) {
            Dialog_Box_Fragment dialog_box_fragment = new Dialog_Box_Fragment();
            dialog_box_fragment.setCancelable(false);
            dialog_box_fragment.show(getSupportFragmentManager(), "GHGJHGJHGHJ");
        } else if (view == clear) {
            this.sudokuView.setValue(0);
        }
    }


    @Override
    public void restartClick() {
        sudokuView.restart();
    }

    @Override
    public void newGame() {
        NewSudokuFragment newSudokuFragment = new NewSudokuFragment();
        newSudokuFragment.setCancelable(false);
        newSudokuFragment.show(getSupportFragmentManager(), "kjdkjfkjkjf");
    }

    @Override
    public void helpClick() {
//        HelpFragment helpFragment = new HelpFragment();
//        helpFragment.setCancelable(false);
//        helpFragment.show(getSupportFragmentManager(),"jkhdfjhfjdh");
    }

    @Override
    public void exitClick() {

    }

    @Override
    public void disable(int value) {
        switch (value) {
            case 1:
                btnOne.setTextColor(Color.parseColor("#212121"));
                break;

            case 2:
                btnTwo.setTextColor(Color.parseColor("#212121"));
                break;

            case 3:
                btnThree.setTextColor(Color.parseColor("#212121"));
                break;

            case 4:
                btnFour.setTextColor(Color.parseColor("#212121"));
                break;

            case 5:
                btnFive.setTextColor(Color.parseColor("#212121"));
                break;

            case 6:
                btnSix.setTextColor(Color.parseColor("#212121"));
                break;

            case 7:
                btnSeven.setTextColor(Color.parseColor("#212121"));
                break;

            case 8:
                btnEight.setTextColor(Color.parseColor("#212121"));
                break;

            case 9:
                btnNine.setTextColor(Color.parseColor("#212121"));
                break;
        }
    }

    @Override
    public void complete() {

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
