package com.css.opdpatient.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.css.opdpatient.R;
import com.css.opdpatient.database.DatabaseHelper;
import com.css.opdpatient.utils.PreferenceData;


/***
 * Created By : Jyoti on 20 Jan 2018 (Saturday)
 * Functionality :  First screen of the application
 *This is Patient application
 */

public class SplashActivity extends ParentActivity {

    private String TAG = "SplashActivity";
    private RelativeLayout mainRelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFullScreen();

        setContentView(R.layout.activity_splash);

        initObjects();

        initUIControls();

        registerForListener();

        startHandler();


    }

    @Override
    void initObjects() {
        super.initObjects();

        try {
            DatabaseHelper databaseHelper = DatabaseHelper.getInstance(this);
            databaseHelper.createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startHandler() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    /*if (PreferenceData.getBooleanPreference(SplashActivity.this, PreferenceData.isLogin)) {
                        navigateToActivity(DashboardActivity.class, true);
                    } else {*/
                        navigateToActivity(HelpActivity.class, true);
                    //}


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    void initUIControls() {
        mainRelative = findViewById(R.id.mainRelative);
    }

    @Override
    void registerForListener() {
        mainRelative.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainRelative:
                navigateToActivity(HelpActivity.class, true);
                break;
        }
    }
}   //end of class SplashActivity
