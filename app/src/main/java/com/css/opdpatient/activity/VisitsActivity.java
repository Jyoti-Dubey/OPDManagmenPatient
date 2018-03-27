package com.css.opdpatient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.VisitsAdapter;
import com.css.opdpatient.model.ApplicationModel;
import com.css.opdpatient.model.VisitsModel;

import java.util.ArrayList;

/***
 * Created By : Jyoti on 20 Feb 2018 (Tuesday)
 * Functionality : This will show the visits of the patient
 */
public class VisitsActivity extends ParentActivity {
    private String TAG = "VisitsActivity";

    private RecyclerView recyclerVisits;
    private RecyclerView.Adapter adapter;
    private ArrayList<VisitsModel> arrayList = new ArrayList<VisitsModel>();

    private ArrayList<ApplicationModel> appArraylist = new ArrayList<ApplicationModel>();
    private TextView txtVisitsName, txtVisitsRelation, txtVisitsDate, txtVisitsInitial;
    private ApplicationClass applicationClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();

    }//end of onCreate

    @Override
    void initUIControls() {
        super.initUIControls();
        recyclerVisits = findViewById(R.id.recyclerVisits);
        imgTopLeft = findViewById(R.id.imgTopLeft);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_Visits));

        ApplicationModel applicationModel = new ApplicationModel();
        applicationClass = (ApplicationClass) getApplicationContext();
        appArraylist.add(applicationModel);

        LinearLayout mainLayout = findViewById(R.id.linearVisits);

        Log.d(TAG, "setUIData: " + applicationClass.arrayList.size());

        final TextView txtVisitsName[] = new TextView[applicationClass.arrayList.size()];
        TextView txtVisitsRelation[] = new TextView[applicationClass.arrayList.size()];
        TextView txtVisitsDate[] = new TextView[applicationClass.arrayList.size()];
        TextView txtVisitsInitial[] = new TextView[applicationClass.arrayList.size()];

        for (int i = 0; i < applicationClass.arrayList.size(); i++) {

            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.recyclerview_visits, mainLayout, false);
            ApplicationModel applicationModel1 = applicationClass.arrayList.get(i);

            txtVisitsInitial[i] = (TextView) view.findViewById(R.id.txtVisitsInitial);
            txtVisitsName[i] = (TextView) view.findViewById(R.id.txtVisitsName);
            txtVisitsRelation[i] = (TextView) view.findViewById(R.id.txtVisitsRelation);
            txtVisitsDate[i] = (TextView) view.findViewById(R.id.txtVisitsDate);

            txtVisitsInitial[i].setText(applicationModel1.getName());
            txtVisitsName[i].setText(applicationModel1.getName());
            txtVisitsRelation[i].setText(applicationModel1.getRelation());
            txtVisitsDate[i].setText(applicationModel1.getDate());

            setBackgroundColor(i, txtVisitsInitial[i]);

            final int finalI = i;
            txtVisitsName[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(VisitsActivity.this, VisitsDetailActivity.class);
                    intent.putExtra("name", txtVisitsName[finalI].getText().toString());
                    startActivity(intent);
                }
            });

            mainLayout.addView(view);
        }
    }

    private void setBackgroundColor(int i, TextView txtVisitsInitial) {
        Log.d(TAG, "setUIData: " + i % 4);
        if (i % 4 == 0) {
            txtVisitsInitial.setBackground(getResources().getDrawable(R.drawable.family_member_florosent_blue));
        } else if (i % 4 == 1) {
            txtVisitsInitial.setBackground(getResources().getDrawable(R.drawable.family_member_yellow));
        } else if (i % 4 == 2) {
            txtVisitsInitial.setBackground(getResources().getDrawable(R.drawable.family_member_purple));
        } else {
            txtVisitsInitial.setBackground(getResources().getDrawable(R.drawable.family_member_violet));
        }
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        imgTopLeft.setOnClickListener(this);
    }


    @Override
    void setAdapter() {
        super.setAdapter();
        for (int j = 0; j < 6; j++) {

            VisitsModel visitsModel = new VisitsModel("Neha", "Sister", "12 Nov,2017");

            arrayList.add(visitsModel);
        }

        adapter = new VisitsAdapter(this, arrayList);
        recyclerVisits.setLayoutManager(new LinearLayoutManager(this));
        recyclerVisits.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.imgTopLeft:
                navigateToActivity(DashboardActivity.class, false);
                break;
        }
    }
}//end of VisitsActivity
