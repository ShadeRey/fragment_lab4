package com.example.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Songs> {

    private LayoutInflater inflater;
    private int layout;
    public static List<Songs> songs;
    private OnLongClickListener listener;

    public interface OnLongClickListener {
        public boolean onLongClick(View view, Songs item, int position);
    }

    public SongAdapter(Context context, int resource, List<Songs> songs) {
        super(context, resource, songs);
        this.songs = songs;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public void setOnLongItemClickListener(OnLongClickListener listener) {
        this.listener = listener;
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

        view.setLongClickable(true);
        view.setOnLongClickListener(view1 -> listener.onLongClick(view1, song, position));

        animeView.setImageResource(song.getAnimeResource());
        nameView.setText(song.getName());
        authorView.setText(song.getAuthor());

        return view;
    }

    @Override
    public void remove(@Nullable Songs object) {
        super.remove(object);
        songs.remove(object);
    }

    @Override
    public void add(Songs obj) {
//        super.add(obj);
        songs.add(obj);
    }
}
