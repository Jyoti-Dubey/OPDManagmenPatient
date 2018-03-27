package com.css.opdpatient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.FamilyListingAdapter;
import com.css.opdpatient.model.FamilyListingDataProvider;

import java.util.ArrayList;

/**
 * Created By : Jyoti on 24 Jan 2018 (Wednessday)
 * Functionality : This class will add patient
 * Nevigation : move towards to dashboard
 */
public class FamilyListingActivity extends ParentActivity implements View.OnClickListener {

    private final String TAG = "FamilyListingActivity";
    private Button btnFamilyListing;

    private RecyclerView recyclerMemberListing;
    private RecyclerView.Adapter adapter;
    private ArrayList<FamilyListingDataProvider> arrayList = new ArrayList<FamilyListingDataProvider>();
    // private String[] txtFamilyMemberListingPersonName, txtFamilyMemberListingRelation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_listing);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();

    }//end of OnCreate()

    void initUIControls() {
        imgTopLeft = findViewById(R.id.imgTopLeft);

        btnFamilyListing = findViewById(R.id.btnFamilyListing);
        recyclerMemberListing = findViewById(R.id.recyclerMemberListing);

    }//end of initUIControls

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_familylisting));
    }

    @Override
    void setAdapter() {


        for (int j = 0; j < 6; j++) {
            FamilyListingDataProvider familyListingDataProvider = new FamilyListingDataProvider(j + "Jyoti", j + "Me");

            arrayList.add(familyListingDataProvider);
        }

        adapter = new FamilyListingAdapter(this, arrayList);
        recyclerMemberListing.setLayoutManager(new LinearLayoutManager(this));
        recyclerMemberListing.setAdapter(adapter);

    }

    void registerForListener() {

        imgTopLeft.setOnClickListener(this);
        btnFamilyListing.setOnClickListener(this);

    }//end of registerForListener


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgTopLeft:
                navigateToActivity(DashboardActivity.class, false);
                break;

            case R.id.btnFamilyListing:
                Intent i = new Intent(FamilyListingActivity.this, AddFamilyMemberActivity.class);
                startActivity(i);
                finish();
                break;

        }//end of switch case
    }//end of onClick()
}//end of FamilyListingActivity
