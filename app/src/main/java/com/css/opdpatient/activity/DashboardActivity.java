package com.css.opdpatient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.squareup.picasso.Picasso;

/***
 * Created By : Jyoti on 20 Jan 2018 (Saturday)
 * Functionality : This class will show the dashboard of Patient Application
 */

public class DashboardActivity extends ParentActivity {

    private String TAG = "DashboardActivity";
    private TextView txtBooktoken, txtShowToken;
    private TextView txtAddFamilyMember;
    private TextView txtName, txtDashboardPatientID, txtBarnchName1, txtBarnchName2;
    private TextView txtAddReports;
    private TextView txtMyVisits;
    private ImageView imgTopRight, image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

    }

    @Override
    void initUIControls() {
        super.initUIControls();
        txtBooktoken = findViewById(R.id.txtBookIcon);
        txtAddFamilyMember = findViewById(R.id.txtAddFamilyMember);
        txtAddReports = findViewById(R.id.txtAddReports);
        txtMyVisits = findViewById(R.id.txtMyVisits);
        txtName = findViewById(R.id.txtName);
        txtDashboardPatientID = findViewById(R.id.txtDashboardPatientID);
        txtShowToken = findViewById(R.id.txtShowToken);
        imgTopLeft = findViewById(R.id.imgTopLeft);
        imgTopRight = findViewById(R.id.imgTopRight);
        image = findViewById(R.id.image);
        txtBarnchName1 = findViewById(R.id.txtBarnchName1);
        txtBarnchName2 = findViewById(R.id.txtBarnchName2);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();

        imgTopLeft.setVisibility(View.GONE);
        imgTopRight.setVisibility(View.VISIBLE);
        imgTopRight.setImageDrawable(getResources().getDrawable(R.drawable.top_ico_booked_token));
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        imgTopRight.setOnClickListener(this);
        txtBooktoken.setOnClickListener(this);
        txtAddFamilyMember.setOnClickListener(this);
        txtAddReports.setOnClickListener(this);
        txtMyVisits.setOnClickListener(this);
        txtShowToken.setOnClickListener(this);
        txtName.setOnClickListener(this);
        txtBarnchName1.setOnClickListener(this);
        txtBarnchName2.setOnClickListener(this);
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_dashboard));
        Picasso.with(this).load("https://randomuser.me/api/portraits/men/9.jpg").into(image);
        /*txtName.setText(PreferenceData.getStringPreference(DashboardActivity.this, NAME));
        Log.d(TAG, "setUIData: " + PreferenceData.getStringPreference(DashboardActivity.this, NAME));

        txtMobileno.setText(PreferenceData.getStringPreference(DashboardActivity.this, mobile_Number));*/
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.imgTopRight:
                navigateToActivity(ConfirmTokenActivity.class, false);
                break;

            case R.id.txtAddFamilyMember:
                Intent intentAddFamilyMember = new Intent(DashboardActivity.this, FamilyListingActivity.class);
                startActivity(intentAddFamilyMember);
                break;

            case R.id.txtBookIcon:
                Intent intentBookIcon = new Intent(DashboardActivity.this, BookTokenActivity.class);
                startActivity(intentBookIcon);
                break;

            case R.id.txtAddReports:
                Intent intentAddReports = new Intent(DashboardActivity.this, MyReportsActivity.class);
                startActivity(intentAddReports);
                break;

            case R.id.txtMyVisits:
                navigateToActivity(VisitsActivity.class, false);

                break;

            case R.id.txtShowToken:
                navigateToActivity(ConfirmTokenActivity.class, false);
                break;

            case R.id.txtName:
                navigateToActivity(MyAccountActivity.class, false);
                break;

           /* case R.id.txtBarnchName1:
                navigateToActivity(BranchVisitActivity.class, false);
                break;
*/
            case R.id.txtBarnchName2:
                navigateToActivity(BranchVisitActivity.class, false);
                break;


        }
    }//end of onClick()
}   //end of DashboardActivity
