package com.css.opdpatient.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.css.opdpatient.R;

/***
 * Created By : Jyoti on 15 Feb 2018 (Thrusday)
 * Functionality : This class will allow the patient to change their patient
 */
public class ChangePasswordActivity extends ParentActivity {
    private String TAG = "ChangePasswordActivity";

    private EditText edtNewPassword, edtConfirmPassword;
    private Button btnChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

    }//end of onCreate

    @Override
    void initUIControls() {
        super.initUIControls();

        imgTopLeft = findViewById(R.id.imgTopLeft);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnChangePassword = findViewById(R.id.btnChangePassword);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_addfamilymember));
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        imgTopLeft.setOnClickListener(this);
        btnChangePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {

            case R.id.imgTopLeft:
                navigateToActivity(MyAccountActivity.class, false);
                break;

            case R.id.btnChangePassword:
                if (edtNewPassword.getText().toString().isEmpty()) {

                    edtNewPassword.setError("Password  required");

                } else if (edtConfirmPassword.getText().toString().isEmpty()) {

                    edtConfirmPassword.setError("Confirm Password");

                } else {
                    navigateToActivity(MyAccountActivity.class, false);
                    break;
                }
        }
    }
}//end of ChangePasswordActivity
