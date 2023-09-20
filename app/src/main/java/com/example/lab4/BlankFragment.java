package com.example.lab4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class BlankFragment extends Fragment {

    ListView songsList;
    ArrayList<Songs> songs = new ArrayList<Songs>();
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    private void setInitialData() {
        songs.add(new Songs("グリフィス", "初め", R.drawable.g));
        songs.add(new Songs("ガッツ", "二階", R.drawable.gu));
        songs.add(new Songs("ヘルメット", "三番目", R.drawable.c));
        songs.add(new Songs("デーモン", "木曜日", R.drawable.d));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitialData();
        songsList = view.findViewById(R.id.songsongList);
        SongAdapter songAdapter = new SongAdapter(getContext(), R.layout.list_item, songs);
        songsList.setAdapter(songAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Songs selectedSong = (Songs) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), "Был выбран пункт " + selectedSong.getName(), Toast.LENGTH_SHORT).show();
            }
        };
        songsList.setOnItemClickListener(itemListener);
    }
}