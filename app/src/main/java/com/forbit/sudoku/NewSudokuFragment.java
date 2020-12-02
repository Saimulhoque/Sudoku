package com.forbit.sudoku;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class NewSudokuFragment extends DialogFragment implements View.OnClickListener {

    MaterialButton btnveasy, btneasy, btnintermediate, btnhard, btnexpert, btnextreme, btnclose;

    public NewSudokuFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.fragment_new_sudoku, null);

        btnveasy = view.findViewById(R.id.veryeasy);
        btneasy = view.findViewById(R.id.easy);
        btnintermediate = view.findViewById(R.id.intermediate);
        btnhard = view.findViewById(R.id.hard);
        btnexpert = view.findViewById(R.id.expert);
        btnextreme = view.findViewById(R.id.extreme);
        btnclose = view.findViewById(R.id.close);

        btnveasy.setOnClickListener(this);
        btneasy.setOnClickListener(this);
        btnintermediate.setOnClickListener(this);
        btnhard.setOnClickListener(this);
        btnexpert.setOnClickListener(this);
        btnextreme.setOnClickListener(this);
        btnclose.setOnClickListener(this);

        AlertDialog alertDialog = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_Dialog_Alert).create();
        alertDialog.setView(view);
        return alertDialog;
    }

    @Override
    public void onClick(View v) {
        if (v == btnclose) {
            dismiss();
        }
    }

}