package com.css.opdpatient.model;

/**
 * Created by Jyoti on 01-02-2018.
 * This class will provide the data to recycler view of family member
 */

public class SelectDoctorModel {
    private final String TAG = "FamilyMemberModelActivity";

    private String imgDoctorImage;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    private boolean isSelected;

    public String getImgDoctorImage() {
        return imgDoctorImage;
    }

    public void setImgDoctorImage(String imgDoctorImage) {
        this.imgDoctorImage = imgDoctorImage;
    }

    private String txtDoctorName;
    private String txtDoctorSpecialist;

    public SelectDoctorModel(String txtDoctorName, String txtDoctorSpecialist, String imgDoctorImage) {

        this.setTxtDoctorName(txtDoctorName);
        this.setTxtDoctorSpecialist(txtDoctorSpecialist);
        this.setImgDoctorImage(imgDoctorImage);
    }


    public String getTxtDoctorName() {
        return txtDoctorName;
    }

    public void setTxtDoctorName(String txtDoctorName) {
        this.txtDoctorName = txtDoctorName;
    }

    public String getTxtDoctorSpecialist() {
        return txtDoctorSpecialist;
    }

    public void setTxtDoctorSpecialist(String txtDoctorSpecialist) {
        this.txtDoctorSpecialist = txtDoctorSpecialist;
    }
}
