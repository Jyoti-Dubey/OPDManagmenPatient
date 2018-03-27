package com.css.opdpatient.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.DoctorAdapter;
import com.css.opdpatient.model.SelectDoctorModel;

import java.util.ArrayList;

public class SelectDoctorActivity extends ParentActivity implements DoctorAdapter.OnClick {
    private String TAG = "SelectDoctorActivity";

    private RecyclerView recyclerSelectDoctor;
    private RecyclerView.Adapter adapter;
    private ArrayList<SelectDoctorModel> arrayList = new ArrayList<SelectDoctorModel>();
    public static String selectedDoctorName ;
    public static String selectedDoctorImage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();

    }//end of onCreate

    @Override
    void initUIControls() {
        super.initUIControls();
        recyclerSelectDoctor = findViewById(R.id.recyclerSelectDoctor);
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
        txtTopCenter.setText(getResources().getString(R.string.top_Branch));
    }


    @Override
    void registerForListener() {
        super.registerForListener();
        imgTopLeft.setOnClickListener(this);
    }

    @Override
    void setAdapter() {
        super.setAdapter();

        SelectDoctorModel selectDoctorModel = new SelectDoctorModel("Dr. Rahul Dubey", "Neurologists", "https://randomuser.me/api/portraits/men/23.jpg");
        SelectDoctorModel selectDoctorModel1 = new SelectDoctorModel("Dr. Mahi Dubey", "Orthopedic", "https://randomuser.me/api/portraits/women/94.jpg");
        SelectDoctorModel selectDoctorModel2 = new SelectDoctorModel("Dr. Suresh Kumar", "Eye Specialist", "https://randomuser.me/api/portraits/men/67.jpg");
        SelectDoctorModel selectDoctorModel3 = new SelectDoctorModel("Dr. Neha Dubey", "Physiotherapist", "https://randomuser.me/api/portraits/women/12.jpg");
        SelectDoctorModel selectDoctorModel4 = new SelectDoctorModel("Dr. Omkara Mishra", "Dentist", "https://randomuser.me/api/portraits/men/78.jpg");

        arrayList.add(selectDoctorModel);
        arrayList.add(selectDoctorModel1);
        arrayList.add(selectDoctorModel2);
        arrayList.add(selectDoctorModel3);
        arrayList.add(selectDoctorModel4);


        adapter = new DoctorAdapter(this, arrayList, this);
        recyclerSelectDoctor.setLayoutManager(new LinearLayoutManager(this));
        recyclerSelectDoctor.setAdapter(adapter);
    }

    @Override
    public void clickPosition(int position) {
        for (int i = 0; i < arrayList.size(); i++) {
            SelectDoctorModel selectDoctorModel = arrayList.get(i);
            selectDoctorModel.setSelected(false);

        }
        SelectDoctorModel selectDoctorModel = arrayList.get(position);
        selectDoctorModel.setSelected(true);
        selectedDoctorName = selectDoctorModel.getTxtDoctorName();
        selectedDoctorImage = selectDoctorModel.getImgDoctorImage();
        onPreviousView();
    }
}//end of SelectDoctorActivity
