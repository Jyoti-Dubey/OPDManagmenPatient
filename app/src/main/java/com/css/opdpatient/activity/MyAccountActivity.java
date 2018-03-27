package com.css.opdpatient.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.utils.PreferenceData;
import com.squareup.picasso.Picasso;

public class MyAccountActivity extends ParentActivity {
    private String TAG = "MyAccountActivity";
    private TextView txtPersonalInformation, txtChangePassword, txtLogout;
    private ImageView imgAccount, imgAccount2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();
    }

    @Override
    void initUIControls() {
        super.initUIControls();
        txtPersonalInformation = findViewById(R.id.txtPersonalInformation);
        txtChangePassword = findViewById(R.id.txtChangePassword);
        txtLogout = findViewById(R.id.txtLogout);
        imgTopLeft = findViewById(R.id.imgTopLeft);
        imgAccount = findViewById(R.id.imgAccount);
        imgAccount2 = findViewById(R.id.imgAccount2);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        txtPersonalInformation.setOnClickListener(this);
        txtChangePassword.setOnClickListener(this);
        txtLogout.setOnClickListener(this);
        imgTopLeft.setOnClickListener(this);
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_MyAcount));
        Picasso.with(this).load("https://randomuser.me/api/portraits/men/9.jpg").into(imgAccount);
        imgAccount.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(this).load("https://randomuser.me/api/portraits/men/9.jpg").into(imgAccount2);
        imgAccount2.setScaleType(ImageView.ScaleType.FIT_XY);

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.txtPersonalInformation:
                navigateToActivity(PersonalInformationActivity.class, false);
                break;

            case R.id.txtChangePassword:
                navigateToActivity(ChangePasswordActivity.class, false);
                break;

            case R.id.txtLogout:
                navigateToActivity(LoginActivity.class, false);
                break;

            case R.id.imgTopLeft:
                onPreviousView();
                break;
        }
    }
}//end of MyAccountActivity
