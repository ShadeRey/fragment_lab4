package com.example.lab4;

import android.icu.text.IDNA;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;



public class InfoFragment extends Fragment {


    public InfoFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String Name, String Author){
        BlankFragment blankFragment = new BlankFragment();
        Name = Songs.name;
        Author = Songs.author;
        Bundle args = new Bundle();
        args.putString("SongName", Name);
        args.putString("SongsAuthor", Author);
        blankFragment.setArguments(args);
        return blankFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        String Name = getArguments().getString("SongName");
        String Author = getArguments().getString("SongAuthor");
        TextView textViewName = view.findViewById(R.id.namE);
        TextView textViewAuthor = view.findViewById(R.id.authoR);
        textViewName.setText(Name);
        textViewAuthor.setText(Author);
        return view;
    }
}