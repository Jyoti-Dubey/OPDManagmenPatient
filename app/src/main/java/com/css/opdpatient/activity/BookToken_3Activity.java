package com.css.opdpatient.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.css.opdpatient.R;

/**
 * Created By : Jyoti on 01 Feb 2018 (Thrusday)
 * Functionality : This class will show the Members booked their token in step 3
 * Nevigation : Move towards dashbboard
 */
public class BookToken_3Activity extends ParentActivity {

    private String TAG = "BookToken_3Activity";
    private Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_token_3);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();
    }//end of onCreate()

    @Override
    void initUIControls() {
        super.initUIControls();
        imgTopLeft = findViewById(R.id.imgTopLeft);
        btnConfirm = findViewById(R.id.btnConfirm);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setVisibility(View.INVISIBLE);
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        btnConfirm.setOnClickListener(this);
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_booktoken3));
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {

            case R.id.btnConfirm:
                navigateToActivity(ConfirmTokenActivity.class, true);
                break;
        }
    }
}//end of BookToken_3Activity
