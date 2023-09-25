package com.example.lab4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class BlankFragment extends Fragment {

    ListView songsList;
    static ArrayList<Songs> songs = new ArrayList<Songs>();
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

    private SongAdapter songAdapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitialData();
        songsList = view.findViewById(R.id.songsongList);
        songAdapter = new SongAdapter(getContext(), R.layout.list_item, songs);
        songAdapter.setOnLongItemClickListener((view1, item, position) -> {
            deleteDialog(position);

            //songs.remove(position);
            //songAdapter.notifyDataSetChanged();
            return true;
        });
        songsList.setAdapter(songAdapter);;
        //songsList.setOnItemLongClickListener();
        initButton(view);
    }

    private void initButton(View view) {
        Button btn = view.findViewById(R.id.btn_add);
        btn.setOnClickListener(this::showDialog);
    }

    public void showDialog(View v){
        if (songAdapter == null) return;
        CustomDialogFragment dialog = new CustomDialogFragment(songAdapter);
        dialog.show(requireActivity().getSupportFragmentManager(), "custom");
    }

    public void deleteDialog(int position){
        DeleteDialogFragment deleteDialogg = new DeleteDialogFragment(songAdapter, position);
        deleteDialogg.show(requireActivity().getSupportFragmentManager(), "delete");
    }
}