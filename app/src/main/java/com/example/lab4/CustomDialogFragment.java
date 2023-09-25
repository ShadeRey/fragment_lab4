package com.example.lab4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    private final SongAdapter songAdapter;

    public CustomDialogFragment(SongAdapter songAdapter) {

        this.songAdapter = songAdapter;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Добавить")
                .setPositiveButton("OK", (dialogInterface, i) -> {
                    AlertDialog dialog = (AlertDialog)dialogInterface;
                    EditText name = dialog.findViewById(R.id.namee);
                    EditText author = dialog.findViewById(R.id.author);
                    songAdapter.add(new Songs(
                            name.getText().toString(),
                            author.getText().toString(),
                            R.drawable.d
                    ));
                })
                .setNegativeButton("Cancel", null)
                .setView(R.layout.dialog)
                .create();

    }
}
