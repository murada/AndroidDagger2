package com.dagger2.android.murad.androiddagger2.modules;

import android.app.Activity;
import android.content.Context;

import com.dagger2.android.murad.androiddagger2.annoations.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Murad on 3/11/2018.
 */


@Module
public class ActivityModule {

    private Activity activity ;

    public ActivityModule(Activity activity){
        this.activity = activity ;
    }

    @Provides
    @ActivityContext
    public Context provideContext(){
        return activity;
    }

    @Provides
    public Activity provideActivity(){
        return activity;
    }

}
