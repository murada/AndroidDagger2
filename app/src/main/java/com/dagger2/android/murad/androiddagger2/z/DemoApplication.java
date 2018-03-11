package com.dagger2.android.murad.androiddagger2.z;

import android.app.Application;
import android.content.Context;

import com.dagger2.android.murad.androiddagger2.componenets.ApplicationComponent;
import com.dagger2.android.murad.androiddagger2.componenets.DaggerActivityComponent;
import com.dagger2.android.murad.androiddagger2.componenets.DaggerApplicationComponent;
import com.dagger2.android.murad.androiddagger2.datasource.DataManager;
import com.dagger2.android.murad.androiddagger2.modules.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by Murad on 3/11/2018.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager ;

    public static DemoApplication get(Context context){
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }


    public ApplicationComponent getApplicationComponent(){
        return  applicationComponent;
    }
}
