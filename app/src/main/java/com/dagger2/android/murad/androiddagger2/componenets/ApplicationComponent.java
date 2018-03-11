package com.dagger2.android.murad.androiddagger2.componenets;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.dagger2.android.murad.androiddagger2.datasource.SharedPreferencesHelper;
import com.dagger2.android.murad.androiddagger2.z.DemoApplication;
import com.dagger2.android.murad.androiddagger2.annoations.ApplicationContext;
import com.dagger2.android.murad.androiddagger2.datasource.DBHelper;
import com.dagger2.android.murad.androiddagger2.datasource.DataManager;
import com.dagger2.android.murad.androiddagger2.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Murad on 3/11/2018.
 */


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPreferencesHelper getPreferenceHelper();

    DBHelper getDbHelper();

}
