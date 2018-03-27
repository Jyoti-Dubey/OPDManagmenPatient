package com.css.opdpatient.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jyoti on 25-01-2018.
 * This class will provide the data to recycler view of family member listing
 */

public class FamilyListingDataProvider {
    private final String TAG = "FamilyListingDataProvider";

    private String imgFamilyMemberListing;
    private String txtFamilyMemberListingPersonName;
    private String txtFamilyMemberListingRelation;

    public FamilyListingDataProvider(String txtFamilyMemberListingPersonName , String txtFamilyMemberListingRelation) {
        this.setImgFamilyMemberListing(imgFamilyMemberListing);
        this.setTxtFamilyMemberListingPersonName(txtFamilyMemberListingPersonName);
        this.setTxtFamilyMemberListingRelation(txtFamilyMemberListingRelation);
    }

    public String getImgFamilyMemberListing() {
        return imgFamilyMemberListing;
    }

    public void setImgFamilyMemberListing(String imgFamilyMemberListing) {
        this.imgFamilyMemberListing = imgFamilyMemberListing;
    }

    public String getTxtFamilyMemberListingPersonName() {
        return txtFamilyMemberListingPersonName;
    }

    public void setTxtFamilyMemberListingPersonName(String txtFamilyMemberListingPersonName) {
        this.txtFamilyMemberListingPersonName = txtFamilyMemberListingPersonName;
    }

    public String getTxtFamilyMemberListingRelation() {
        return txtFamilyMemberListingRelation;
    }

    public void setTxtFamilyMemberListingRelation(String txtFamilyMemberListingRelation) {
        this.txtFamilyMemberListingRelation = txtFamilyMemberListingRelation;
    }
}//FamilyListingDataProvider
