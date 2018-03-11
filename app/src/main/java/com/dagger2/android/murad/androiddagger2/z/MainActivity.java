package com.dagger2.android.murad.androiddagger2.z;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dagger2.android.murad.androiddagger2.R;
import com.dagger2.android.murad.androiddagger2.componenets.ActivityComponent;
import com.dagger2.android.murad.androiddagger2.componenets.DaggerActivityComponent;
import com.dagger2.android.murad.androiddagger2.datasource.DataManager;
import com.dagger2.android.murad.androiddagger2.datasource.User;
import com.dagger2.android.murad.androiddagger2.modules.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager ;

    private ActivityComponent activityComponenet;

    private TextView userInfoTextView ;
    private TextView accessTokenTextView ;


    public ActivityComponent getActivityComponent(){
        if(activityComponenet == null){
            activityComponenet = DaggerActivityComponent.builder().activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getApplicationComponent())
                    .build();
        }
        return activityComponenet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        userInfoTextView = (TextView) findViewById(R.id.tv_user_info);
        accessTokenTextView = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        dataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = dataManager.getAcessToken();
        if(token != null){
            accessTokenTextView.setText(token);
        }
        getUser();
    }

    private void createUser(){
        try {
            dataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = dataManager.getUser(1L);
            userInfoTextView.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }

}
