package com.forbit.sudoku;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

public class SettingsFragment extends DialogFragment implements View.OnClickListener {
    MaterialButton btnclose,btnorientation;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.fragment_settings, null);

        btnclose=view.findViewById(R.id.close);
        btnorientation=view.findViewById(R.id.orientation);

        btnclose.setOnClickListener(this);
        btnorientation.setOnClickListener(this);

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