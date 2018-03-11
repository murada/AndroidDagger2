package com.dagger2.android.murad.androiddagger2.componenets;

import com.dagger2.android.murad.androiddagger2.z.MainActivity;
import com.dagger2.android.murad.androiddagger2.annoations.PerActivity;
import com.dagger2.android.murad.androiddagger2.modules.ActivityModule;

import dagger.Component;

/**
 * Created by Murad on 3/11/2018.
 */


@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
