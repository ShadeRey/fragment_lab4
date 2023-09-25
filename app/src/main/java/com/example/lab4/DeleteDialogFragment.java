package com.example.lab4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DeleteDialogFragment extends DialogFragment {
    private SongAdapter songAdapter;
    private int position;

    public DeleteDialogFragment(SongAdapter songAdapter, int position) {
        this.songAdapter = songAdapter;
        this.position = position;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Удалить?")
                .setPositiveButton("OK", (dialogInterface, i) -> {
                    Songs item = songAdapter.getItem(position);
                    Toast.makeText(getContext(), "Был удален пункт " + item.getName(), Toast.LENGTH_SHORT).show();
                    songAdapter.remove(item);
                })
                .setNegativeButton("Cancel", null)
                .create();

    }

}
