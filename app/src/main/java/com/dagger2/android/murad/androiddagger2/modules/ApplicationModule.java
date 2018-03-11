package com.dagger2.android.murad.androiddagger2.modules;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import com.dagger2.android.murad.androiddagger2.annoations.ApplicationContext;
import com.dagger2.android.murad.androiddagger2.annoations.DatabaseInfo;
import com.dagger2.android.murad.androiddagger2.datasource.SharedPreferencesHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Murad on 3/11/2018.
 */


@Module
public class ApplicationModule {

    private final Application application ;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }


    @Provides
    @ApplicationContext
    public Context provideContext(){
        return application;
    }

    @Provides
    @DatabaseInfo
    public String provideDatabaseName(){
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    public Integer provideDatabaseVersion(){
        return 2 ;
    }

    @Provides
    public SharedPreferences provideSharedPreferences(){
        return application.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

}
