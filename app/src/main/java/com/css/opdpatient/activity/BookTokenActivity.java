package com.css.opdpatient.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.model.SelectDoctorModel;
import com.squareup.picasso.Picasso;

/***
 * Created By : Jyoti on 24 Jan 2018 (wednesday)
 * Functionality : This class will show the book token of Patient Application
 */

public class BookTokenActivity extends ParentActivity {

    private String TAG = "BookTokenActivity";
    private LinearLayout llVisitType;
    private Button btnBookToken;
    private TextView txtTimeSlot1, txtTimeSlot2, txtSelectDoctor, txtSelectBranch;
    private RelativeLayout relSelectDoctor, relSelectBranch;
    private String timeText = "txtTimeSlot1";
    private ImageView imgDoctor;
    private TextView BookTokenValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_token);

        initUIControls();

        initTopBarComponents();

        bindBookTokenLayout();

        registerForListener();

    }

    @Override
    void initUIControls() {
        super.initUIControls();
        imgTopLeft = findViewById(R.id.imgTopLeft);
        llVisitType = findViewById(R.id.llVisitType);
        btnBookToken = findViewById(R.id.btnBookToken);
        relSelectDoctor = findViewById(R.id.relSelectDoctor);
        relSelectBranch = findViewById(R.id.relSelectBranch);
        txtTimeSlot1 = findViewById(R.id.txtTimeSlot1);
        txtTimeSlot2 = findViewById(R.id.txtTimeSlot2);
        txtSelectDoctor = findViewById(R.id.txtSelectDoctor);
        txtSelectBranch = findViewById(R.id.txtSelectBranch);
        imgDoctor = findViewById(R.id.imgDoctor);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }

    /***
     * will bind book token layout
     */
    private void bindBookTokenLayout() {
        for (int i = 0; i < 1; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.include_visit_type, null);
            llVisitType.addView(view);
        }
    }   //end of bindBookTokenLayout

    @Override
    void registerForListener() {
        super.registerForListener();
        btnBookToken.setOnClickListener(this);
        relSelectBranch.setOnClickListener(this);
        relSelectDoctor.setOnClickListener(this);
        txtTimeSlot1.setOnClickListener(this);
        txtTimeSlot2.setOnClickListener(this);
        imgTopLeft.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUIData();
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_booktoken));
        if (SelectDoctorActivity.selectedDoctorName != null) {
            txtSelectDoctor.setText(SelectDoctorActivity.selectedDoctorName + "");
        }

        if (SelectBranchActivity.selectedBranch != null) {
            txtSelectBranch.setText(SelectBranchActivity.selectedBranch + "");
        }

        if (SelectDoctorActivity.selectedDoctorImage != null) {
            Picasso.with(this)
                    .load(SelectDoctorActivity.selectedDoctorImage)
                    .placeholder(R.drawable.user_default_pic_large)
                    .error(R.drawable.user_default_pic_large)
                    .into(imgDoctor);
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {

            case R.id.imgTopLeft:
                navigateToActivity(DashboardActivity.class, false);
                break;

            case R.id.btnBookToken:
                navigateToActivity(BookTokenStep_2Activity.class, false);
                break;

            case R.id.relSelectDoctor:
                navigateToActivity(SelectDoctorActivity.class, false);
                break;

            case R.id.relSelectBranch:
                navigateToActivity(SelectBranchActivity.class, false);
                break;

            case R.id.txtTimeSlot1:
                txtTimeSlot1.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.time_active), null, null, null);
                txtTimeSlot2.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.time_inactive), null, null, null);
                txtTimeSlot1.setBackground(getResources().getDrawable(R.drawable.booktokenborder));
                txtTimeSlot2.setBackground(getResources().getDrawable(R.drawable.booktokenbordergray));
                txtTimeSlot1.setTextColor(getResources().getColor(R.color.white));
                txtTimeSlot2.setTextColor(getResources().getColor(R.color.grey));
                timeText = "txtTimeSlot1";
                break;

            case R.id.txtTimeSlot2:
                txtTimeSlot2.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.time_active), null, null, null);
                txtTimeSlot1.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.time_inactive), null, null, null);
                txtTimeSlot1.setBackground(getResources().getDrawable(R.drawable.booktokenbordergray));
                txtTimeSlot2.setBackground(getResources().getDrawable(R.drawable.booktokenborder));
                txtTimeSlot2.setTextColor(getResources().getColor(R.color.white));
                txtTimeSlot1.setTextColor(getResources().getColor(R.color.grey));
                timeText = "txtTimeSlot2";
                break;
        }
    }//end of onClick
}//end of BookToken
