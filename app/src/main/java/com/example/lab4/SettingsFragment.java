package com.example.lab4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

public class SettingsFragment extends Fragment {

    public static final String APP_PREFERENCES = "mysettings";
    private static final String PREFS_LANGUAGE = "Language";
    private static final String PREFS_NOTIFICATIONS = "Notifications";
    private static final String PREFS_FONT_SIZE = "FontSize";
    private static final String PREFS_THEME = "Theme";
    private static final String PREFS_LOCK_SCREEN = "LockScreen";
    SharedPreferences settings;

    public SettingsFragment() {
        // Required empty public constructor
    }


    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings);
        settings = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}