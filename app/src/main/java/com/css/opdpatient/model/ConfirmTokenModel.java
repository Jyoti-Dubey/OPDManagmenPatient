package com.css.opdpatient.model;

/**
 * Created by Jyoti on 22-02-2018.
 * This class will provide the data to recycler view of Confirm token
 */

public class ConfirmTokenModel {

    private String txtConfirmInitial;

    public String getTxtConfirmInitial() {
        return txtConfirmInitial;
    }

    public void setTxtConfirmInitial(String txtConfirmInitial) {
        this.txtConfirmInitial = txtConfirmInitial;
    }

    private String txtConfirmName;
    private String txtConfirmRelation;
    private String txtConfirmPatientID;
    private String txtConfirmTokenView;
    private String txtConfirmEstimatedTimeView;
    private String txtConfirmCurrentView;
    private String txtConfirmDoctorView;
    private String txtConfirmClinicView;


    public ConfirmTokenModel(String txtConfirmName, String txtConfirmRelation, String txtConfirmPatientID, String txtConfirmTokenView, String txtConfirmEstimatedTimeView,
                             String txtConfirmCurrentView, String txtConfirmDoctorView, String txtConfirmClinicView) {
        this.setTxtConfirmName(txtConfirmName);
        this.setTxtConfirmRelation(txtConfirmRelation);
        this.setTxtConfirmPatientID(txtConfirmPatientID);
        this.setTxtConfirmTokenView(txtConfirmTokenView);
        this.setTxtConfirmEstimatedTimeView(txtConfirmEstimatedTimeView);
        this.setTxtConfirmCurrentView(txtConfirmCurrentView);
        this.setTxtConfirmDoctorView(txtConfirmDoctorView);
        this.setTxtConfirmClinicView(txtConfirmClinicView);
    }

    public String getTxtConfirmName() {
        return this.txtConfirmName;
    }

    public void setTxtConfirmName(String txtConfirmName) {
        this.txtConfirmName = txtConfirmName;
    }

    public String getTxtConfirmRelation() {
        return txtConfirmRelation;
    }

    public void setTxtConfirmRelation(String txtConfirmRelation) {
        this.txtConfirmRelation = txtConfirmRelation;
    }

    public String getTxtConfirmPatientID() {
        return txtConfirmPatientID;
    }

    public void setTxtConfirmPatientID(String txtConfirmPatientID) {
        this.txtConfirmPatientID = txtConfirmPatientID;
    }

    public String getTxtConfirmTokenView() {
        return txtConfirmTokenView;
    }

    public void setTxtConfirmTokenView(String txtConfirmTokenView) {
        this.txtConfirmTokenView = txtConfirmTokenView;
    }

    public String getTxtConfirmEstimatedTimeView() {
        return txtConfirmEstimatedTimeView;
    }

    public void setTxtConfirmEstimatedTimeView(String txtConfirmEstimatedTimeView) {
        this.txtConfirmEstimatedTimeView = txtConfirmEstimatedTimeView;
    }

    public String getTxtConfirmCurrentView() {
        return txtConfirmCurrentView;
    }

    public void setTxtConfirmCurrentView(String txtConfirmCurrentView) {
        this.txtConfirmCurrentView = txtConfirmCurrentView;
    }

    public String getTxtConfirmDoctorView() {
        return txtConfirmDoctorView;
    }

    public void setTxtConfirmDoctorView(String txtConfirmDoctorView) {
        this.txtConfirmDoctorView = txtConfirmDoctorView;
    }

    public String getTxtConfirmClinicView() {
        return txtConfirmClinicView;
    }

    public void setTxtConfirmClinicView(String txtConfirmClinicView) {
        this.txtConfirmClinicView = txtConfirmClinicView;
    }
}//end of ConfirmTokenModel
