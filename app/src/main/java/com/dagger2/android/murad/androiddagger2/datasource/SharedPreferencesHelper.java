package com.dagger2.android.murad.androiddagger2.datasource;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Murad on 3/11/2018.
 */

@Singleton
public class SharedPreferencesHelper {

    public static String PREF_KEY_ACCESS_TOKEN = "access-token";
    private SharedPreferences sharedPreferences ;

    @Inject
    public SharedPreferencesHelper(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences ;
    }

    public void put(String key , String value){
        sharedPreferences.edit().putString(key,value).apply();
    }

    public void put(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key) {
        sharedPreferences.edit().remove(key).apply();
    }


}
