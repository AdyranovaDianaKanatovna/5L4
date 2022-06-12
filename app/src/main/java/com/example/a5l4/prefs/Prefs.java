package com.example.a5l4.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;


    public void save(Context context) {
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);

    }

    public void saveState() {
        preferences.edit().putBoolean("isShown", true).apply();
    }

    public boolean isShown() {
        return preferences.getBoolean("isShown", false);
    }
}
