package com.css.opdpatient.model;

/**
 * Created by Jyoti on 21-02-2018.
 * This class will provide the data to recycler view of branch
 */

public class BranchModel {
    private String txtBranchName;
    private String txtBranchPlace;
    private String txtBranchNumber;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public BranchModel(String txtBranchName, String txtBranchPlace, String txtBranchNumber) {
        this.setTxtBranchName(txtBranchName);
        this.setTxtBranchPlace(txtBranchPlace);
        this.setTxtBranchNumber(txtBranchNumber);
    }

    public String getTxtBranchName() {
        return txtBranchName;
    }

    public void setTxtBranchName(String txtBranchName) {
        this.txtBranchName = txtBranchName;
    }

    public String getTxtBranchPlace() {
        return txtBranchPlace;
    }

    public void setTxtBranchPlace(String txtBranchPlace) {
        this.txtBranchPlace = txtBranchPlace;
    }

    public String getTxtBranchNumber() {
        return txtBranchNumber;
    }

    public void setTxtBranchNumber(String txtBranchNumber) {
        this.txtBranchNumber = txtBranchNumber;
    }
}
