package com.css.opdpatient.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.ConfirmTokenAdapter;
import com.css.opdpatient.model.ConfirmTokenModel;

import java.util.ArrayList;

/***
 * Created By : Jyoti on 17 Feb 2018 (Saturday)
 * Functionality : This will show the confirmed token to the patient
 */
public class ConfirmTokenActivity extends ParentActivity {

    private String TAG = "ConfirmTokenActivity";
    private ImageView imgTopRight;
    private RecyclerView recyclerConfirmToken;
    private RecyclerView.Adapter adapter;
    private ArrayList<ConfirmTokenModel> arrayList = new ArrayList<ConfirmTokenModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_token);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();
    }//end of onCreate

    @Override
    void initUIControls() {
        super.initUIControls();
        imgTopLeft = findViewById(R.id.imgTopLeft);
        imgTopLeft.setVisibility(View.INVISIBLE);
        imgTopRight = findViewById(R.id.imgTopRight);
        recyclerConfirmToken = findViewById(R.id.recyclerConfirmToken);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
        imgTopRight.setVisibility(View.VISIBLE);
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        imgTopRight.setOnClickListener(this);
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_booktoken3));
    }

    @Override
    void setAdapter() {
        super.setAdapter();

        ConfirmTokenModel confirmTokenModel = new ConfirmTokenModel("Rupam Mishra", "Cousin", "2548", "50",
                "4:45 PM", "50", "Dr. Rahul Dubey", "Navrangpura Cross Road");


        ConfirmTokenModel confirmTokenModel2 = new ConfirmTokenModel("Chaitra Pujar", "Sister-in-law", "5364", "45",
                "2:15 PM", "45", "Dr. Mahi Dubey", "Navrangpura Cross Road");

        ConfirmTokenModel confirmTokenModel1 = new ConfirmTokenModel("Raushni Dubey", "Sister", "2856", "40",
                "2:45 PM", "40", "Dr. Neha Dubey", "Gujarat High Court");

        arrayList.add(confirmTokenModel);
        arrayList.add(confirmTokenModel2);
        arrayList.add(confirmTokenModel1);

        adapter = new ConfirmTokenAdapter(this, arrayList);
        recyclerConfirmToken.setLayoutManager(new LinearLayoutManager(this));
        recyclerConfirmToken.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.imgTopRight:
                navigateToActivity(DashboardActivity.class, false);
                break;
        }
    }
}//end of ConfirmTokenActivity
