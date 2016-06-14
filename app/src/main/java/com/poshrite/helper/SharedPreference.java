package com.poshrite.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class SharedPreference {

    String PREFS_FILE_NAME;
    String DATA_KEY;
    SharedPreferences settings;
    Context context;


    /*	public SharedPreference(Context contextP,String preferencesFileName,String preferencesKey) {
            this.PREFS_FILE_NAME = preferencesFileName;
            this.DATA_KEY = preferencesKey;
            this.settings = contextP.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        }*/
    public SharedPreference(Context contextP, String preferencesFileName) {
        this.PREFS_FILE_NAME = preferencesFileName;
        this.settings = contextP.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void addValue(String preferencesKey, String text) {
        Editor editor;
        editor = settings.edit();
        editor.putString(preferencesKey, text);
        editor.commit();
    }

    public void addMoreValue(String preferencesKey, String newValue) {
        Editor editor;
        String previousValue = settings.getString(preferencesKey, "");
        String newtext = null;
        newtext = append(previousValue, newValue);
        editor = settings.edit();
        editor.clear();
        editor.putString(preferencesKey, newtext);
        editor.commit();
    }

    protected String append(String previousText, String newText) {
        String fresh = previousText + " " + newText;
        return fresh;
    }

    public String getValue(String preferencesKey) {
        String text;
        text = settings.getString(preferencesKey, "");
        return text;
    }

    public void clearSharedPreference() {
        Editor editor;
        editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public void removeValue(String preferencesKey) {
        Editor editor;
        editor = settings.edit();
        editor.putString(preferencesKey, "");
        editor.commit();
    }
}
