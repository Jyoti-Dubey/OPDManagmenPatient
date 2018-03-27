package com.css.opdpatient.model;

/**
 * Created by Jyoti on 20-02-2018.
 * This class will provide the data to recycler view visited member
 */

public class VisitsModel {
    private final String TAG = "VisitsModel";


    private String txtVisitsName;
    private String txtVisitsRelation;
    private String txtVisitsDate;

    public VisitsModel(String txtVisitsName, String txtVisitsRelation, String txtVisitsDate) {
        this.setTxtVisitsName(txtVisitsName);
        this.setTxtVisitsRelation(txtVisitsRelation);
        this.setTxtVisitsDate(txtVisitsDate);
    }

    public String getTxtVisitsName() {
        return txtVisitsName;
    }

    public void setTxtVisitsName(String txtVisitsName) {
        this.txtVisitsName = txtVisitsName;
    }

    public String getTxtVisitsRelation() {
        return txtVisitsRelation;
    }

    public void setTxtVisitsRelation(String txtVisitsRelation) {
        this.txtVisitsRelation = txtVisitsRelation;
    }

    public String getTxtVisitsDate() {
        return txtVisitsDate;
    }

    public void setTxtVisitsDate(String txtVisitsDate) {
        this.txtVisitsDate = txtVisitsDate;
    }
}
