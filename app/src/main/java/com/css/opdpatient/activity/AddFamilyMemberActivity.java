package com.css.opdpatient.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.css.opdpatient.R;

/***
 * Created By : Jyoti on 23 Jan 2018 (Tuesday)
 * Functionality : This will add family member to the account 
 */
public class AddFamilyMemberActivity extends ParentActivity {
    private String TAG = "AddFamilyMemberActivity";

    private Button btnAddMember;
    private EditText edtFamilyFname, edtFamilyLname, edtPatientID;
    private TextView alertRelationship;
    private TextView txtMale, txtFemale;
    private String gender = "male";
    private int selectedRelationPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_member);

        initUIControls();

        initTopBarComponents();

        registerForListener();

        setUIData();

    }//end of onCreate()


    @Override
    void initUIControls() {
        super.initUIControls();

        edtFamilyFname = findViewById(R.id.edtFamilyFname);
        edtFamilyLname = findViewById(R.id.edtFamilyLname);
        edtPatientID = findViewById(R.id.edtPatientID);
        alertRelationship = findViewById(R.id.alertRelationship);
        txtFemale = findViewById(R.id.txtFemale);
        txtMale = findViewById(R.id.txtMale);
        btnAddMember = findViewById(R.id.btnAddMember);
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
        txtTopCenter.setText(getResources().getString(R.string.top_addfamilymember));
    }


    @Override
    void registerForListener() {
        super.registerForListener();
        btnAddMember.setOnClickListener(this);
        imgTopLeft.setOnClickListener(this);
        alertRelationship.setOnClickListener(this);
        txtMale.setOnClickListener(this);
        txtFemale.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {

            case R.id.imgTopLeft:
                navigateToActivity(DashboardActivity.class, false);
                break;

            case R.id.btnAddMember:
                if (edtFamilyFname.getText().toString().isEmpty()) {

                    edtFamilyFname.setError("First Name required");

                } else if (edtFamilyLname.getText().toString().isEmpty()) {

                    edtFamilyLname.setError("Last Name required");

                } else {
                    navigateToActivity(FamilyMemberActivity.class, false);
                }
                break;

            case R.id.txtMale:
                txtMale.setTextColor(getResources().getColor(R.color.colorAccent));
                txtFemale.setTextColor(getResources().getColor(R.color.black));
                gender = "male";
                break;

            case R.id.txtFemale:
                txtFemale.setTextColor(getResources().getColor(R.color.colorAccent));
                txtMale.setTextColor(getResources().getColor(R.color.black));
                gender = "female";
                break;

            case R.id.alertRelationship:

                final AlertDialog.Builder builderSingle = new AlertDialog.Builder(AddFamilyMemberActivity.this);
                builderSingle.setTitle("Select your relation\n");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddFamilyMemberActivity.this, android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("Father");
                arrayAdapter.add("Brother");
                arrayAdapter.add("Sister");
                arrayAdapter.add("Daughter");
                arrayAdapter.add("Grandfather");
                arrayAdapter.add("Grandmother");
                arrayAdapter.add("Sister-in-law");
                arrayAdapter.add("Brother-in-law");
                arrayAdapter.add("Niece");
                arrayAdapter.add("Nephew");
                arrayAdapter.add("Spouse");
                arrayAdapter.add("Cousin");


                builderSingle.setSingleChoiceItems(arrayAdapter, selectedRelationPos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertRelationship.setText(arrayAdapter.getItem(i) + "");
                        selectedRelationPos = i;
                        dialogInterface.dismiss();
                    }
                });

                builderSingle.show();
        }
    }

}//end of AddFamilyMemberActivity
