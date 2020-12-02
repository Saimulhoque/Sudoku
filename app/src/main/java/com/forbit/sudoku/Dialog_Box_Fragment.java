package com.forbit.sudoku;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Dialog_Box_Fragment extends DialogFragment implements View.OnClickListener {
    MaterialButton btn1, btn2, btn3, btn4;

    private MainActivityListener listener;

    public Dialog_Box_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.listener = (MainActivityListener) getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.fragment_dialog__box_, null);
         btn1 = view.findViewById(R.id.restart_sudoku);
         btn2 = view.findViewById(R.id.new_sudoku);
         btn3 = view.findViewById(R.id.help_setting);
         btn4 = view.findViewById(R.id.exit);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        AlertDialog alertDialog = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_Dialog_Alert).create();
        alertDialog.setView(view);
        return alertDialog;
    }

    @Override
    public void onClick(View v) {

        if(v==btn4){
            dismiss();
            if(listener!=null){
                listener.exitClick();
            }
        }else if(v==btn3){
            if(listener!=null){
                listener.helpClick();
            }
        }else if(v==btn2){
            if(listener!=null){
                listener.newGame();
            }
        }else if(v==btn1){
            if(listener!=null){
                dismiss();
                listener.restartClick();
            }
        }

    }
}