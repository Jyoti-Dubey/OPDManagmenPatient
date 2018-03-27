package com.css.opdpatient.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.css.opdpatient.R;
/***
 * Created By : Jyoti on 20 Feb 2018 (Tuesday)
 * Functionality : This will allow  to change their password at the time of login if needed
 */
public class ForgotPasswordActivity extends ParentActivity {
    private String TAG = "ForgotPasswordActivity";

    private EditText edtForgotPassword;
    private Button btnForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initUIControls();

        registerForListener();

    }

    @Override
    void initUIControls() {
        super.initUIControls();
        edtForgotPassword = findViewById(R.id.edtForgotPassword);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        btnForgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId())
        {
            case R.id.btnForgotPassword:
                navigateToActivity(LoginActivity.class,false);
                break;
        }
    }
}//end of ForgotPasswordActivity
