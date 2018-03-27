package com.css.opdpatient.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.css.opdpatient.R;
import com.css.opdpatient.adapter.BranchAdapter;
import com.css.opdpatient.model.BranchModel;

import java.util.ArrayList;

public class SelectBranchActivity extends ParentActivity implements BranchAdapter.OnClick {
    private String TAG = "SelectBranchActivity";
    private RecyclerView recyclerSelectBranch;
    private RecyclerView.Adapter adapter;
    private ArrayList<BranchModel> arrayList = new ArrayList<BranchModel>();
    public static String selectedBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_branch);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

        setAdapter();

    }//end of onCreate

    @Override
    void initUIControls() {
        super.initUIControls();
        recyclerSelectBranch = findViewById(R.id.recyclerSelectBranch);
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

        BranchModel branchModel = new BranchModel("Gujarat High Court", "S.G Highway,Ahmedabad", "9986549750");
        BranchModel branchModel1 = new BranchModel("Navrangpura Cross Road", "Near Navrangpura Ambavadi,Ahmedabad", "96897885648");
        BranchModel branchModel2 = new BranchModel("CG Road", "Opposite CG Square Mall,Ahmedabad", "9775648324");

        arrayList.add(branchModel);
        arrayList.add(branchModel1);
        arrayList.add(branchModel2);

        adapter = new BranchAdapter(this, arrayList, this);
        recyclerSelectBranch.setLayoutManager(new LinearLayoutManager(this));
        recyclerSelectBranch.setAdapter(adapter);
    }

    @Override
    public void clickPosition(int position) {
        for (int i = 0; i < arrayList.size(); i++) {
            BranchModel branchModel = arrayList.get(i);
            branchModel.setSelected(false);
        }
        BranchModel branchModel = arrayList.get(position);
        branchModel.setSelected(true);
        selectedBranch = branchModel.getTxtBranchName();
        onPreviousView();

    }
}//end of SelectBranchActivity
