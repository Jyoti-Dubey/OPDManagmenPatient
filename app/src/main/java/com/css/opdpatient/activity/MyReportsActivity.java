package com.css.opdpatient.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.MyReportsAdapter;
import com.css.opdpatient.database.DatabaseHelper;
import com.css.opdpatient.model.MyReportsModelActivity;
import com.css.opdpatient.utils.DateUtils;

import java.util.ArrayList;

/***
 * Created By : Jyoti on 02 Feb 2018 (Friday)
 * Functionality : This will show the reports to the respective patient
 */
public class MyReportsActivity extends ParentActivity {

    private String TAG = "AddFamilyMemberActivity";

    private RecyclerView recyclerMyReports;
    private RecyclerView.Adapter adapter;
    private ArrayList<MyReportsModelActivity> arrayList = new ArrayList<MyReportsModelActivity>();
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reports);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();

    }//end of onCreate()

    void initUIControls() {

        imgTopLeft = findViewById(R.id.imgTopLeft);
        recyclerMyReports = findViewById(R.id.recyclerMyReports);
    }

    @Override
    protected void initTopBarComponents() {
        super.initTopBarComponents();
        imgTopLeft.setImageDrawable(getResources().getDrawable(R.drawable.top_back));
    }

    @Override
    void setUIData() {
        txtTopCenter.setText(getResources().getString(R.string.top_myreports));
    }//end of setUIData

    @Override
    void setAdapter() {
        databaseHelper = DatabaseHelper.getInstance(this);
        String qry = "SELECT * FROM report ";
        Cursor cur = databaseHelper.getDataUsingCustomQuery(qry, null);
        Log.d(TAG, "setAdapter: query" + qry + " count :: " + cur.getCount());

        if (cur.getCount() > 0) {
            cur.moveToFirst();

            for (int i = 0; i < cur.getCount(); i++) {

                MyReportsModelActivity myReportsModelActivity = new MyReportsModelActivity();

                myReportsModelActivity.setId(cur.getString(cur.getColumnIndex("id")));
                myReportsModelActivity.setTxtMyReportsDisease(cur.getString(cur.getColumnIndex("description")));
                myReportsModelActivity.setTxtMyReportsName(cur.getString(cur.getColumnIndex("patient_name")));
                myReportsModelActivity.setTxtMyReportsDate(cur.getString(cur.getColumnIndex("date")));

                String dateFormat = cur.getString(cur.getColumnIndex("date"));
                dateFormat = DateUtils.changeDateFormat(dateFormat, "dd/MM/yyyy", "dd MMM yyyy");

                myReportsModelActivity.setTxtMyReportsDate(dateFormat);

                arrayList.add(myReportsModelActivity);

                cur.moveToNext();
            }
        }
        adapter = new MyReportsAdapter(this, arrayList);
        recyclerMyReports.setLayoutManager(new LinearLayoutManager(this));
        recyclerMyReports.setAdapter(adapter);

    }//end of setAdapter


    void registerForListener() {
        imgTopLeft.setOnClickListener(this);
    }//end of registerForListener

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgTopLeft:
                navigateToActivity(DashboardActivity.class, false);
        }
    }//end of onclick

}//end of MyReportsActivity
