package com.example.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Songs> {

    private LayoutInflater inflater;
    private int layout;
    private List<Songs> songs;

    public SongAdapter(Context context, int resource, List<Songs> songs) {
        super(context, resource, songs);
        this.songs = songs;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if (convertView == null) {
            view = inflater.inflate(this.layout, parent, false);
        }
        else {
            view = convertView;
        }

        ImageView animeView = view.findViewById(R.id.anime);
        TextView nameView = view.findViewById(R.id.name);
        TextView authorView = view.findViewById(R.id.author);

        Songs song = songs.get(position);

        animeView.setImageResource(song.getAnimeResource());
        nameView.setText(song.getName());
        authorView.setText(song.getAuthor());

        return view;
    }
}
