package com.example.lab4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.lab4.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    public static final String APP_PREFERENCES = "mysettings";
    private static final String PREFS_LANGUAGE = "Language";
    private static final String PREFS_NOTIFICATIONS = "Notifications";
    private static final String PREFS_FONT_SIZE = "FontSize";
    private static final String PREFS_THEME = "Theme";
    private static final String PREFS_LOCK_SCREEN = "LockScreen";
    SharedPreferences settings;
    private FragmentSettingsBinding binding;

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
        settings = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadSaved();
        initListeners();
    }

    private void initListeners(){
        SharedPreferences prefs = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        binding.languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                edit.putInt(PREFS_LANGUAGE, i);
                edit.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.notificationSwitch.setOnCheckedChangeListener((i, b) -> {
            edit.putBoolean(PREFS_NOTIFICATIONS, b);
            edit.apply();
        });
        binding.fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                edit.putInt(PREFS_FONT_SIZE, i);
                edit.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        binding.themeRadioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            edit.putInt(PREFS_THEME, i);
            edit.apply();
        });
        binding.screenLockSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                edit.putInt(PREFS_LOCK_SCREEN, i);
                edit.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    };

    private void loadSaved() {
        SharedPreferences prefs = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        int selectedLanguage = prefs.getInt(PREFS_LANGUAGE, 0);
        boolean notifications = prefs.getBoolean(PREFS_NOTIFICATIONS, true);
        int fontSize = prefs.getInt(PREFS_FONT_SIZE, 0);
        int selectedTheme = prefs.getInt(PREFS_THEME, 0);
        int screenLock = prefs.getInt(PREFS_LOCK_SCREEN, 0);

        binding.languageSpinner.setSelection(selectedLanguage);
        binding.notificationSwitch.setChecked(notifications);
        binding.themeRadioGroup.check(selectedTheme);
        binding.fontSizeSeekBar.setProgress(fontSize);
        binding.screenLockSeekBar.setProgress(screenLock);
    }
}