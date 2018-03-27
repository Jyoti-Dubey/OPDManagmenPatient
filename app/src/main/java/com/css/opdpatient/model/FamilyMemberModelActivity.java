package com.css.opdpatient.model;

/**
 * Created by Jyoti on 01-02-2018.
 * This class will provide the data to recycler view of family member
 */

public class FamilyMemberModelActivity {
    private final String TAG = "FamilyMemberModelActivity";

    private String imgFamilyMember;
    private String txtFamilyMemberName;
    private String txtFamilyMemberRelation;
    private String txtFamilyMemberPatientID;

    public String getTxtFamilyMemberPatientID() {
        return txtFamilyMemberPatientID;
    }

    public void setTxtFamilyMemberPatientID(String txtFamilyMemberPatientID) {
        this.txtFamilyMemberPatientID = txtFamilyMemberPatientID;
    }

    public FamilyMemberModelActivity(String txtFamilyMemberName, String txtFamilyMemberRelation , String txtFamilyMemberPatientID) {
        this.setTxtFamilyMemberName(txtFamilyMemberName);
        this.setTxtFamilyMemberRelation(txtFamilyMemberRelation);
        this.setTxtFamilyMemberPatientID(txtFamilyMemberPatientID);
    }

    public String getImgFamilyMember() {
        return imgFamilyMember;
    }

    public void setImgFamilyMember(String imgFamilyMember) {
        this.imgFamilyMember = imgFamilyMember;
    }

    public String getTxtFamilyMemberName() {
        return txtFamilyMemberName;
    }

    public void setTxtFamilyMemberName(String txtFamilyMemberName) {
        this.txtFamilyMemberName = txtFamilyMemberName;
    }

    public String getTxtFamilyMemberRelation() {
        return txtFamilyMemberRelation;
    }

    public void setTxtFamilyMemberRelation(String txtFamilyMemberRelation) {
        this.txtFamilyMemberRelation = txtFamilyMemberRelation;
    }
}
