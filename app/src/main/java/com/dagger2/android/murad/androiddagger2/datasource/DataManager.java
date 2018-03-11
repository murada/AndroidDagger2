package com.dagger2.android.murad.androiddagger2.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.ResourceBusyException;

import com.dagger2.android.murad.androiddagger2.annoations.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Murad on 3/11/2018.
 */


@Singleton
public class DataManager {

    private Context context ;
    private DBHelper dbHelper ;
    private SharedPreferencesHelper sharedPreferencesHelper ;

    @Inject
    public DataManager(@ApplicationContext Context context , DBHelper dbHelper , SharedPreferencesHelper sharedPreferencesHelper){
        this.context = context ;
        this.dbHelper = dbHelper ;
        this.sharedPreferencesHelper = sharedPreferencesHelper;
    }

    public void saveAccessToken(String accessToken){
        sharedPreferencesHelper.put(SharedPreferencesHelper.PREF_KEY_ACCESS_TOKEN,accessToken);
    }

    public String getAcessToken(){
        return sharedPreferencesHelper.get(SharedPreferencesHelper.PREF_KEY_ACCESS_TOKEN,null);
    }

    public Long createUser(User user )throws Exception{
        return dbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException,NullPointerException{
        return dbHelper.getUser(userId);
    }

}
