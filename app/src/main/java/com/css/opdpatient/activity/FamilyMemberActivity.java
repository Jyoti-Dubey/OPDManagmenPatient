package com.css.opdpatient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.FamilyMemberAdapter;
import com.css.opdpatient.model.ApplicationModel;
import com.css.opdpatient.model.FamilyMemberModelActivity;

import java.util.ArrayList;

/**
 * Created By : Jyoti on 01 Feb 2018 (Thrusday)
 * Functionality : This class will show the Members added in the application
 * Nevigation :
 */
public class FamilyMemberActivity extends ParentActivity implements View.OnClickListener {
    private final String TAG = "FamilyMemberActivity";

    private Button btnFamilyMember;

    private RecyclerView recyclerFamilyMember;
    private RecyclerView.Adapter adapter;
    private ArrayList<FamilyMemberModelActivity> arrayList = new ArrayList<FamilyMemberModelActivity>();

    private ArrayList<ApplicationModel> appArraylist = new ArrayList<ApplicationModel>();
    private TextView txtFamilyMemberName, txtFamilyMemberRelation, txtFamilyMemberPatientID, txtFamilyMemberInitial;
    private ApplicationClass applicationClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_member);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();

        // getIntentData();
    }//end of onCreate()


    @Override
    void initUIControls() {
        super.initUIControls();
        imgTopLeft = findViewById(R.id.imgTopLeft);

        btnFamilyMember = findViewById(R.id.btnFamilyMember);
        recyclerFamilyMember = findViewById(R.id.recyclerFamilyMember);

        txtFamilyMemberName = findViewById(R.id.txtFamilyMemberName);
        txtFamilyMemberRelation = findViewById(R.id.txtFamilyMemberRelation);

        txtFamilyMemberInitial = findViewById(R.id.txtFamilyMemberInitial);
        txtFamilyMemberPatientID = findViewById(R.id.txtFamilyMemberPatientID);

        imgTopLeft = findViewById(R.id.imgTopLeft);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));

    }

    @Override
    void setAdapter() {
        super.setAdapter();
        for (int j = 0; j < 6; j++) {

            FamilyMemberModelActivity familyMemberModelActivity = new FamilyMemberModelActivity("Neha", "Sister", "1212");

            arrayList.add(familyMemberModelActivity);
        }

        adapter = new FamilyMemberAdapter(this, arrayList);
        recyclerFamilyMember.setLayoutManager(new LinearLayoutManager(this));
        recyclerFamilyMember.setAdapter(adapter);
    }

    @Override
    void registerForListener() {
        super.registerForListener();
        btnFamilyMember.setOnClickListener(this);
        imgTopLeft.setOnClickListener(this);
    }

    @Override
    void setUIData() {
        super.setUIData();
        txtTopCenter.setText(getResources().getString(R.string.top_familymember));

        ApplicationModel applicationModel = new ApplicationModel();
        applicationClass = (ApplicationClass) getApplicationContext();
        appArraylist.add(applicationModel);

        LinearLayout mainLayout = findViewById(R.id.linearFamily);
        Log.d(TAG, "setUIData: " + applicationClass.arrayList.size());

        TextView txtFamilyMemberName[] = new TextView[applicationClass.arrayList.size()];
        TextView txtFamilyMemberRelation[] = new TextView[applicationClass.arrayList.size()];
        TextView txtFamilyMemberPatientID[] = new TextView[applicationClass.arrayList.size()];
        TextView txtFamilyMemberInitial[] = new TextView[applicationClass.arrayList.size()];

        for (int i = 0; i < applicationClass.arrayList.size(); i++) {

            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.recyclerview_family_member, mainLayout, false);
            ApplicationModel applicationModel1 = applicationClass.arrayList.get(i);

            txtFamilyMemberInitial[i] = (TextView) view.findViewById(R.id.txtFamilyMemberInitial);
            txtFamilyMemberName[i] = (TextView) view.findViewById(R.id.txtFamilyMemberName);
            txtFamilyMemberRelation[i] = (TextView) view.findViewById(R.id.txtFamilyMemberRelation);
            txtFamilyMemberPatientID[i] = (TextView) view.findViewById(R.id.txtFamilyMemberPatientID);

            txtFamilyMemberInitial[i].setText(applicationModel1.getName());
            txtFamilyMemberName[i].setText(applicationModel1.getName());
            txtFamilyMemberRelation[i].setText(applicationModel1.getRelation());
            txtFamilyMemberPatientID[i].setText(applicationModel1.getId());

            setBackgroundColor(i, txtFamilyMemberInitial[i]);

            mainLayout.addView(view);
        }
    }

    /***
     * @param i
     * @param txtFamilyMemberInitial
     */
    private void setBackgroundColor(int i, TextView txtFamilyMemberInitial) {
        Log.d(TAG, "setUIData: " + i % 4);
        if (i % 4 == 0) {
            txtFamilyMemberInitial.setBackground(getResources().getDrawable(R.drawable.family_member_florosent_blue));
        } else if (i % 4 == 1) {
            txtFamilyMemberInitial.setBackground(getResources().getDrawable(R.drawable.family_member_yellow));
        } else if (i % 4 == 2) {
            txtFamilyMemberInitial.setBackground(getResources().getDrawable(R.drawable.family_member_purple));
        } else {
            txtFamilyMemberInitial.setBackground(getResources().getDrawable(R.drawable.family_member_violet));
        }
    }

    /**
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTopLeft:
                navigateToActivity(DashboardActivity.class, false);
                break;

            case R.id.btnFamilyMember:
                Intent intent = new Intent(FamilyMemberActivity.this, AddFamilyMemberActivity.class);
                startActivity(intent);
                break;
        }
    }//end of onClick()

    /*@Override
    void getIntentData() {
        Bundle b = getIntent().getExtras();

        txtFamilyMemberName.setText(" " + b.getString("First_Name"));
        txtFamilyMemberName.setText("" + b.getString("Last_Name"));
        txtFamilyMemberRelation.setText("" + b.getString("Relation"));

        Log.d(TAG, "getIntentData: " + b.getString("First_Name"));
        Log.d(TAG, "getIntentData: " + b.getString("Last_Name"));
        Log.d(TAG, "getIntentData: " + b.getString("Relation"));

    }*/
}//end of FamilyMemberActivity
